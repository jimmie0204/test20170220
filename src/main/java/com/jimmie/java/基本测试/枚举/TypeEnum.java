package com.jimmie.java.基本测试.枚举;/**
 * Created by jimmie on 2018/4/17.
 */

/**
 * @author jimmie
 * @create 2018-04-17 下午6:16
 */

public enum TypeEnum implements ConstantGenerator2.Constant {
    CAL_ATTRID(0, "aaa"),
    NOT_CAL_ATTRID(1, "bbbb"),
    RELATION_ATTRID(2,"cc"),
    LOAD_DATA_ATTRID(3,"ddd");

    private int code;
    private String field;

    public static final ConstantGenerator2<TypeEnum> GENERATOR = ConstantGenerator2.create(TypeEnum.class);

    private TypeEnum(int code, String field) {
        this.code = code;
        this.field = field;
    }

    public int getCode() {
        return code;
    }

    public String getField() {
        return field;
    }

    public static void main(String[] args){
        TypeEnum byCode = GENERATOR.getByCode(1);
        System.out.println(byCode.getField());

    }

}
