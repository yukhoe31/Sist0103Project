package spring.day0430.anno3;

import org.springframework.stereotype.Component;

@Component
public class TestDao {

	public void insert(String name)
	{
		System.out.println(name+"���� db�� �߰���");
	}
	
	public void delete(String num)
	{
		System.out.println(num+"�� ����Ÿ �����Ϸ�!!!");
	}
	public void select(String name)
	{
		System.out.println(name+"���� �ֿ뱳�����Ϳ��� ������~~");
	}
}
