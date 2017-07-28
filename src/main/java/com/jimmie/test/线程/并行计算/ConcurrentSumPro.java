package com.jimmie.test.线程.并行计算;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentSumPro {
	private int coreCpuNum;
	private ExecutorService  executor;
//	private List<FutureTask<Long>> tasks = new ArrayList<FutureTask<Long>>();
	final CompletionService<Long> completionService;
	public ConcurrentSumPro(){
		coreCpuNum = Runtime.getRuntime().availableProcessors();
		executor = Executors.newFixedThreadPool(coreCpuNum);
		completionService = new ExecutorCompletionService<Long>(executor);
		System.out.println(coreCpuNum);
	}
	class SumCalculator implements Callable<Long>{
		int nums[];
		int start;
		int end;
		public SumCalculator(final int nums[],int start,int end){
			this.nums = nums;
			this.start = start;
			this.end = end;
		}
		@Override
		public Long call() throws Exception {
			long sum =0;
			for(int i=start;i<end;i++){
				sum += nums[i];
			}
			return sum;
		}
	}
	public long sum(int[] nums){
		int start,end,increment;
		// 根据CPU核心个数拆分任务，创建FutureTask并提交到Executor 
		for(int i=0;i<coreCpuNum;i++){
			increment = nums.length / coreCpuNum+1;
			start = i*increment;
			end = start+increment;
			System.out.println(increment+"==="+start+"=="+end+"==");
			if(end > nums.length){
				end = nums.length; 
			}
			SumCalculator calculator = new SumCalculator(nums, start, end);
//			FutureTask<Long> task = new FutureTask<Long>(calculator);
//			tasks.add(task);
			
			if(!executor.isShutdown()){
//				executor.submit(task);
				completionService.submit(calculator);
			}
		}
		return getPartSum();
	}
	public long getPartSum(){
		long sum = 0;
/*		for(int i=0;i<tasks.size();i++){
			try {
				sum += completionService.take().get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}*/
		while(true){
			Future<Long> f;
			try {
				f = completionService.take();
				if(f==null)
					break;
				sum += f.get();
				System.out.println(sum);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		close();
		return sum;
	}
	public void close(){
		executor.shutdown();
	}
	
	public static void main(String[] args) {
//		int arr[] = new int[]{1, 22, 33, 4, 52, 61, 7, 48, 10, 11 };
		int arr[] =new int[1000000];
		for(int i=0;i<1000000;i++){
			arr[i] = i;
		}
		long begin = System.nanoTime();
		long sum =0;
		sum = new ConcurrentSumPro().sum(arr);
/*		for(int j=0;j<1000000;j++){
			sum+=arr[j];
		}*/
		System.out.println("sum: " + sum);
		System.out.println(System.nanoTime()-begin);//11250390
		//																		 3258536
	}
}