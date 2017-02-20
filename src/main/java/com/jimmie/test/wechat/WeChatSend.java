package com.jimmie.test.wechat;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author anguangcan
 *微信发送工具类
 *
 */
public class WeChatSend {
	
	private static Logger LOG = LoggerFactory.getLogger(WeChatSend.class);
	
	/**
	 * 发送url
	 */
	private static String BASE_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=%s";
	
	/**
	 * 获取token 的url
	 */
	private static String ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=%s&corpsecret=%s";
	
	/**
	 * 上传临时素材的url
	 */
	private static String UPLOAD_URL = "https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%s"; 
	
	/**
	 * @param corpId  密钥
	 * @param secret  密钥
	 * @param content 发送内容
	 * 发送至微信企业公众号并返回结果
	 * @return
	 */
	public static < T > boolean send(String corpId , String secret , T content) {
		
		if(StringUtils.isBlank(corpId) || StringUtils.isBlank(secret)
				|| content == null || StringUtils.isBlank(content.toString()))
			
			throw new IllegalArgumentException("获取accessToken参数有问题corpId [ " + corpId + 
					" ] & secret [ " + secret + " ] & content [ " + content + " ]");
		
		String accessToken = getAccessToken(corpId , secret);
		
		if(StringUtils.isBlank(accessToken)) {
			LOG.warn("获取accessToken失败!!!");
			return false;
		}
		
		String url = String.format(BASE_URL, accessToken);
		
		ResponseDTO response = HttpConnectionManager.post(url, content);
		
		int statusCode = response.getCode();
		if(statusCode == 200) {
			String resultJson = (String) response.getAttach();
			LOG.info("从微信api获取的结果信息 resultJson [ " + resultJson + " ]");
			
			if(StringUtils.isBlank(resultJson)) {
				LOG.warn("获取消息发送信息为空!!!!");
				return false;
			}
			
			MsgSendResult msgResult = JSON.parseObject(resultJson, MsgSendResult.class);
			String errorMsg = msgResult.getErrmsg();
			
			return (!StringUtils.isBlank(errorMsg) && WeChatConstants.SEND_RESULT_OK.equals(errorMsg)) ? true : false;
			
		}
		
		return false;
	}
	
	
	/**
	 * @param fileName 文件名
	 * 获取介质id
	 * @return
	 */
	public static String getMediaId(String corpId , String secret , String type , File file) {
		
		String accessToken = getAccessToken(corpId, secret);
		
		if(StringUtils.isBlank(accessToken)) {
			LOG.warn("获取accessToken失败!!!");
			return null;
		}
		
		String uploadUrl = String.format(UPLOAD_URL, accessToken , type);
		
		Map<String,ContentBody> params = new HashMap<String,ContentBody>();
		FileBody fileBody = new FileBody(file);
		params.put("media", fileBody);
		
		ResponseDTO response = HttpConnectionManager.post(uploadUrl, params, false, false);
		
		int statusCode = response.getCode();
		
		if(statusCode == 200) {
			String resultJson = (String)response.getAttach();
			
			LOG.info("从微信api获取的结果信息 resultJson [ " + resultJson + " ]");
			if(StringUtils.isBlank(resultJson)) {
				LOG.warn("获取消息发送信息为空!!!!");
				return null;
			}
			
			UploadResult uploadResult = JSON.parseObject(resultJson, UploadResult.class);
			LOG.info("获取微信api信息[ " + uploadUrl + " ]");
			String mediaId = uploadResult == null ? null :uploadResult.getMediaId();
			
			return mediaId;
		} else {
			LOG.error("请求微信api错误[ " + response.toString() + " ]");
		}
		
		return null;
		
	}
	
	/**
	 * @param corpId
	 * @param secret
	 * 获取accessToken
	 * @return
	 */
	public static String getAccessToken(String corpId , String secret) {
		
		if(StringUtils.isBlank(corpId) || StringUtils.isBlank(secret))
			throw new IllegalArgumentException("获取accessToken参数有问题corpId [ " + corpId + " ] & secret [ " + secret + " ]");
		
		String url = String.format(ACCESS_TOKEN_URL, corpId,secret);
		
		LOG.info("请求accessToken的url信息为 url [ " + url + " ]");
		
		ResponseDTO response = HttpConnectionManager.doGet(url);
		
		int statusCode = response.getCode();
		LOG.info("调用微信获取accessToken服务,获取状态码信息 statusCode [ " + statusCode + " ]");
		
		if(statusCode == 200) {
			String resultJson = (String) response.getAttach();
			TokenResult token = JSON.parseObject(resultJson, TokenResult.class);
			String accessToken = token == null ? null : token.getAccess_token();
			
			return accessToken;
		}
		
		return null;
		
	}
	
	/**
	 * @author anguangcan
	 * 消息发送结果类
	 *
	 */
	static class MsgSendResult {
		
		/**
		 * 错误code
		 */
		private int errcode;
		
		/**
		 * 错误信息
		 */
		private String errmsg;
		
		private String invaliduser;
		
		private String invalidparty;
		
		private String invalidtag;

		public int getErrcode() {
			return errcode;
		}

		public void setErrcode(int errcode) {
			this.errcode = errcode;
		}

		public String getErrmsg() {
			return errmsg;
		}

		public void setErrmsg(String errmsg) {
			this.errmsg = errmsg;
		}

		public String getInvaliduser() {
			return invaliduser;
		}

		public void setInvaliduser(String invaliduser) {
			this.invaliduser = invaliduser;
		}

		public String getInvalidparty() {
			return invalidparty;
		}

		public void setInvalidparty(String invalidparty) {
			this.invalidparty = invalidparty;
		}

		public String getInvalidtag() {
			return invalidtag;
		}

		public void setInvalidtag(String invalidtag) {
			this.invalidtag = invalidtag;
		}
	}
	
	/**
	 * @author anguangcan
	 * 获取token结果信息
	 *
	 */
	static class TokenResult {
		
		/**
		 * 错误code
		 */
		private Integer errcode;
		
		/**
		 * 错误信息
		 */
		private String errmsg;
		
		/**
		 * accessToken
		 */
		private String access_token;
		
		/**
		 * 过期时间
		 */
		private String expires_in;

		public Integer getErrcode() {
			return errcode;
		}

		public void setErrcode(Integer errcode) {
			this.errcode = errcode;
		}

		public String getErrmsg() {
			return errmsg;
		}

		public void setErrmsg(String errmsg) {
			this.errmsg = errmsg;
		}

		public String getAccess_token() {
			return access_token;
		}

		public void setAccess_token(String access_token) {
			this.access_token = access_token;
		}

		public String getExpires_in() {
			return expires_in;
		}

		public void setExpires_in(String expires_in) {
			this.expires_in = expires_in;
		}
	}
	
	/**
	 * @author anguangcan
	 * 上传临时文件返回报文类
	 *
	 */
	static class UploadResult {
		
		/**
		 * 文件类型
		 */
		private String type;
		
		/**
		 * 介质id
		 */
		@JSONField(name = "media_id")
		private String mediaId;
		
		/**
		 * 创建时间
		 */
		@JSONField(name = "create_at")
		private Date createTime;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}

		public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		
	}
	
	public static void main(String[] args) {
		
		String corpId = "wx641f8c8e08c53957";
		String secret = "lRFfUqpI5WbQHpphNvVlxfVYT21xsQ2dW2QV12O3g5P_wBn4t2X_3r-lq-IG8zad";
		
		File file = new File("d:\\微信截图_20161103193012.png");
		
		String mediaId = getMediaId(corpId, secret, "image", file);
		
		String content = "{\"touser\": \"@all\",\"toparty\": \"\",\"totag\": \"\",\"msgtype\": \"image\",\"agentid\": 10,\"image\": {\"media_id\":\"" + mediaId + "\"}";
		
		boolean res = send(corpId, secret, content);
		System.out.println(res);
		
	}
	
}
