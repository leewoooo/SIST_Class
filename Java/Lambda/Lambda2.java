package day1211;

/**
 * Lamb식에서 사용할 수 있는 Interface는 SAM(single abstract method)이여야 한다.
 * annotation을 사용하면 Interface가 하나의 추상 method만 가질 수 있게 된다.
 * @author owner
 */
@FunctionalInterface
public interface Lambda2 {
	
	public void name(String name);

}// Lambda1
