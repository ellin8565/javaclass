#DAY11
___

###제네릭
>객체 생성 때 클래스 타입을 다양하게 할 수 있는 문법 
>- 일반적인 코드를 작성하고 이 코드를 다양한 타입의 객체에 대하여 재사용


---
	1)
	class  Box{
	Object data;
	public void setData (Object data) {
		this.data = data;
		
	}
	public Object getData() {
		return data;
	}
	}
	public class Test {
	public static void main(String[] args) {
		Box b=new Box();
		b.setData(10);
		System.out.println(b.getData());
		b.setData("Hello");
		System.out.println(b.getData());
		//=> 프로그램 코드를 쓸 때 내가 알아서 타입을 지정하고 형변환.
	}
	}


	2)
	class  Box<T>{
	T data;
	public void setData (T data) {
		this.data = data;
		
	}
	public T getData() {
		return data;
	}
	}
	public class Test {
	public static void main(String[] args) {
		Box<String> b=new Box<String>();
		b.setData("Hello");
		String s=b.getData();
	}
	}
    
    


###컬렉션 프레임(자료구조)
>List : 순서가 있는 데이터 모임
>- 순서가 있으므로 각각의 데이터가 순서로 구분

>Set : 순서가 없는 데이터 모임
>- 각각의 데이터가 구분이 안되지 않아 중복이 있을 수 없음(데이터 중복 불가)

>Map : 이름이 있는 데이터 모임(K,V 형태의 데이터 모임)
>- set에 데이터 바구니가 담겼다고 생각하거나 list인데 순서 대신 이름을 매겼음
>- entry : key-value쌍을 다루기 위한 인터페이스/클래스..?
>- entrySet : entry 집합들


###List 인터페이스
>ArrayList : 가변길이  배열(일반적으로 사용)
>- 탐색에 유리
>
>LinkedList : 다음 데이터의 주소 저장
>- 추가/삭제에 유리
>

###Stack&Quene
>Stack : LIFO(Last In First Out), 마지막 저장한 데이터를 가장 먼저 꺼내게 되는 구조
>- push(), pop()
>
>Queue : FIFO(First In First Out), 처음 저장한 데이터를 가장 먼저 꺼내게 되는 구조
>- offer(), poll()

---
	3)
    import java.awt.List;
	import java.util.ArrayList;

	public class ArrayListTest {
	public static void main(String[] args) {
	ArrayList<String> list =new ArrayList<>();
	
	list.add("MILK");
	list.add("BREAD");
	list.add("BUTTER");
	list.add(1,"APPLE");//1번칸에 끼어듬.
	list.set(2, "GRAPE"); //2번칸 grape로 대체
	list.remove(3); //인덱스 3의 원소 삭제
	
	for (int i=0;i<list.size();i++) System.out.println(list.get(i));
	}
	}
    
    //출력결과
    MILK
	APPLE
	GRAPE
	
    
    4)
	import java.util.LinkedList;

	public class LinkedListTEst {
	public static void main(String[] args) {
	LinkedList<String> list =new LinkedList<String>();
	//인터페이스의 좋은점...같은 add라는 이름이지만 다른 동작
	
	list.add("MILK");
	list.add("BREAD");
	list.add("BUTTER");
	list.add(1,"APPLE");
	list.set(2, "GRAPE"); //2번칸 grape로 대체
	list.remove(3); //인덱스 3의 원소 삭제
	
	for (int i=0;i<list.size();i++) System.out.println(list.get(i));
	}
	}
    //출력결과
    MILK
	APPLE
	GRAPE
---

	5)
    import java.util.HashSet;

	public class SetTest {
	public static void main(String[] args) {
	HashSet<String> set=new HashSet<String>();
	
	set.add("Milk");
	set.add("Bread");
	set.add("Butter");
	set.add("Cheese");
	set.add("Ham");
	set.add("Ham");
    //순서가 없고 중복 불가
	System.out.println(set); //hashset의 toString\
    
	}
	}
    //출력결과
    [Ham, Butter, Cheese, Milk, Bread]


###iterator(반복자)
>컬렉션의 원소들을 하나씩 처리하는데 사용
>

---
	6)
	import java.util.HashSet;
	import java.util.Iterator;

	public class SetTest {
	public static void main(String[] args) {
	HashSet<String> set=new HashSet<String>();
	
	set.add("Milk");
	set.add("Bread");
	set.add("Butter");
	set.add("Cheese");
	set.add("Ham");
	set.add("Ham");
	//System.out.println(set);
	//for(String s:set) System.out.println(s); =>향상된 for문
	//string  :데이터 덩어리
	//iterator : 반복자
	Iterator <String> iter=set.iterator();
	while(iter.hasNext()) System.out.println(iter.next());
	}
	}
	//출력결과
    Ham
    Butter
	Cheese
	Milk
	Bread
---
	7)entry/entrySet
	import java.util.HashMap;
	import java.util.Map;
	class Student {
	int number;
	String name;
	
	public Student(int number, String name) {
		this.number=number;
		this.name=name;
	}
	public String toString() {
		return name;
	}
	}
	public class MapTest {
	public static void main(String[] args) {
	Map<String, Student> st=new HashMap<String, Student>();
	st.put("1" ,new Student(1,"구준표"));
	st.put("2" ,new Student(2,"금잔디"));
	st.put("3" ,new Student(3,"윤지후"));
	
	System.out.println(st);

	
	st.remove("2");
	st.put("3", new Student(3,"소이정"));
	System.out.println(st.get("3"));
	
	//map 탐색(한개의 타입: 꾸러미) Entry 단위로 탐색
	for(Map.Entry<String,Student> s: st.entrySet()) {
		String key=s.getKey();
		Student value =s.getValue();
		System.out.println("key="+key+" value="+value);
	}
	
	//map에서 데이터를 가져올 댄 키값으로 질의
	System.out.println(st.get("1"));
	//Map 탐색 key로 접근
	for(String k: st.keySet()) System.out.println(st.get(k));
	}
	}
    //출력결과
    {1=구준표, 2=금잔디, 3=윤지후}
	소이정
	key=1 value=구준표
	key=3 value=소이정
	구준표
	구준표
	소이정
    
    
    8)
    import java.util.LinkedList;
	import java.util.Queue;
	import java.util.Stack;

	public class StackQueue {
	public static void main(String[] args) {
	Stack st =new Stack();
	Queue q= new LinkedList();
	
	st.push("0");
	st.push("1");
	st.push("2");
	
	q.offer("0");
	q.offer("1");
	q.offer("2");
	System.out.println("=Stack=");
	while(!st.empty()) {
		System.out.println(st.pop());
	}
	System.out.println("=Queue=");
	while(!q.isEmpty()) {
		System.out.println(q.poll());
	}
	}
	}
    //
    =Stack=
	2
	1
	0
	=Queue=
	0
	1
	2
    
###Comparator&Comparable
>인터페이스로 컬렉션을 정렬하는 필요하나 메서드 정의
>Comparable : Comparable은 구현하는 클래스들은 같은 타입의 객체끼리 서로 비교할 수 있는 클래스들 구현
>- 기본 정렬기준을 구현하는데 사용
>ex) compareTo return 0/1/-1 : 같음/큼/작음
>
>Comparator : 기본 정렬기준 외에 다른 기준으로 정렬하고자 할 때 사용


---
	9)
    import java.util.Arrays;

	class Account implements Comparable<Account>{
	private String id;
	private String name;
	private int balance;
	public Account(String id, String name, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	@Override
	public int compareTo(Account o) { //정렬기준 
		// TODO Auto-generated method stub
		if( this.balance > o.balance)
			return -1;
		else if( this.balance == o.balance)
			return 0;
		else
			return 1;
	}
	}

	public class ComparableTest {
	public static void main(String[] args) {
		Account[] accArr = new Account[3];
		accArr[0] = new Account("10112", "Hong",5000);
		accArr[1] = new Account("20132", "Kim",3000);
		accArr[2] = new Account("10012", "Lee",7000);
		
		Arrays.sort(accArr);
		for(Account a : accArr)
			System.out.println(a);
	}
	}
    //출력결과
    Account [id=10012, name=Lee, balance=7000]
	Account [id=10112, name=Hong, balance=5000]
	Account [id=20132, name=Kim, balance=3000]

