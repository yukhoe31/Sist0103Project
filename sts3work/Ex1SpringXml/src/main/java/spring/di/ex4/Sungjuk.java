package spring.di.ex4;

public class Sungjuk {

	Student stu;
	int kor,eng,mat;
	
	
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	
	public void writeSungjuk()
	{
		System.out.println("�⸻���");
		System.out.println("�л���: "+stu.getName());
		System.out.println("����: "+stu.getAge());
		System.out.println("��������: "+kor);
		System.out.println("��������: "+eng);
		System.out.println("��������: "+mat);
		
		System.out.println("���� ��̵�");
		for(String h:stu.getHobby())
			System.out.println("\t"+h);
	}
	
	
}
