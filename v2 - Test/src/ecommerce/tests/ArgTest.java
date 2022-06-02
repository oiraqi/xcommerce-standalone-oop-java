package ecommerce.tests;

class ArgTest{
	public static void main(String[] args){
		if(args.length == 0){
			System.out.println("No args have been specified");
			return;
		}
		System.out.println("The args you specified are:");
		for(int i = 0; i < args.length; i++)
			System.out.println(args[i]);
	}

}