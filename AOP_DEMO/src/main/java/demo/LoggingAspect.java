package demo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	// CON VALOR DE RETORNO
	@AfterReturning(value="execution(* demo.ShoppingCart.quantity())", returning="retVal")
	public void afterReturning(String retVal) {
		System.out.println("estoy en el after returning " + retVal);
	}
	
	// otra forma, con valor de Retorno
	@Pointcut("execution(* demo.ShoppingCart.quantity())")
    public void afterReturningPointCut() {		
	}
	
	@AfterReturning(pointcut="afterReturningPointCut()", returning="retVal")
	public void afterReturning2(String retVal) {
		System.out.println("estoy en after returning " + retVal);
	}
	
	
	// CON PARAMETROS Y SU LECTURA
	@Before("execution(* demo.ShoppingCart.checkout2(..))")
	public void beforeLogger3(JoinPoint jp) {
		System.out.println("estoy en el beforeLogger3");
		System.out.println(jp.getSignature());
		System.out.println(jp.getArgs()[0].toString());
	}
	
	// CON PARAMETROS
	@Before("execution(* demo.ShoppingCart.checkout2(..))")
	public void beforeLogger2() {
		System.out.println("estoy en el beforeLogger2");
	}
	
	@After("execution(* *.*.checkout2(..))")
	public void afterLogger2() {
		System.out.println("estoy en el afterLogger2");
	}
	
	
	// SIN PARAMETROS
	@Before("execution(* demo.ShoppingCart.checkout())")
	public void beforeLogger() {
		System.out.println("estoy en el beforeLogger");
	}
	
	@After("execution(* *.*.checkout())")
	public void afterLogger() {
		System.out.println("estoy en el afterLogger");
	}
}
