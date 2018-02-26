package fibo;

import	java.util.concurrent.*;	
public	class	Fibonacci extends	RecursiveAction	{	
				int	n,	result;	
				public	Fibonacci(int	_n)	{	n=_n;		}	
			 public	void	compute()	{	
								if(n<2)	{	
												this.result	=	n;	
												return;	
								}	
								Fibonacci	left	=	new	Fibonacci(this.n-1);	
								Fibonacci	right	=	new	Fibonacci(this.n-2);	
								left.fork();	
								right.compute();	
								left.join();	
								this.result	=	left.result	+	right.result;	
				}	
				public	static	void	main(String[]	args)	{	
								ForkJoinPool	pool	=	new	ForkJoinPool(2);	
								Fibonacci	task	=	new	Fibonacci(40);	
								pool.invoke(task);	
								int	result	=	task.result;	
								System.out.println(result);
				}	
}	