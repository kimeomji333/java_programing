package map;

public class MemberHashMapTest {
	public static void main(String[] args) {
		MemberHashMap hashMap = new MemberHashMap();
		
		Member n1 = new Member(1, "김사과");
		Member n2 = new Member(2, "반하나");
		Member n3 = new Member(3, "임체리");
		Member n4 = new Member(4, "김요한");
		
		hashMap.addMember(n1);
		hashMap.addMember(n2);
		hashMap.addMember(n3);
		hashMap.addMember(n4);
		
		hashMap.removeMember(4);
		hashMap.showAllMember();
	}

}
