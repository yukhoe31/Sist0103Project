package spring.day0430.anno1;

import org.springframework.stereotype.Component;

@Component //�ڵ����� bean�� ���(id�� Ŭ���������� �ڵ����_ù���ڸ� �ҹ��� myDao�� ���̵� �ȴ�.)
public class MyDao implements DaoInter {

	@Override
	public void insertData(String str) {
		// TODO Auto-generated method stub
		
		System.out.println(str + "_������ db�� �߰�����!!!");

	}

	@Override
	public void deleteData(String num) {
		// TODO Auto-generated method stub
		
		System.out.println(num + "_�� �ش��ϴ� ������ ���� ����");
	}

}
