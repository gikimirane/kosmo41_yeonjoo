import java.util.Scanner;

public class Quiz7 {

	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);

		int InputName = 0;
		int InputKor = 0, InputEng = 0, InputMath = 0;


		System.out.println("������ ���� �Է� �� �ڽ��� ������ Ȯ�� �ϼ���");

		System.out.println("�̸��� �Է��ϼ���");
		InputName = s.nextInt();
		System.out.println("ù��° ���� ������ �Է� �ϼ���");
		InputKor = s.nextInt();
		System.out.println("�ι�° ���� ������ �Է� �ϼ���");
		InputEng = s.nextInt();
		System.out.println("����° ���� ������ �Է� �ϼ���");
		InputMath = s.nextInt();

		int sum = 0;
		sum = InputKor + InputKor + InputKor;

		int Aver = 0;
		Aver = sum / 3;

		if(Aver >= 90)
		System.out.println(InputName + "���� �����" + Aver + "�̰� ������ A �Դϴ�" );
		else if(Aver >= 80)
		System.out.println(InputName + "���� �����" + Aver + "�̰� ������ B �Դϴ�" );
		else if(Aver >= 70)
		System.out.println(InputName + "���� �����" + Aver + "�̰� ������ C �Դϴ�" );
		else if(Aver >= 50)
		System.out.println(InputName + "���� �����" + Aver + "�̰� ������ D �Դϴ�" );
		else 
		System.out.println(InputName + "���� �����" + Aver + "�̰� ������ E �Դϴ�" );


	}

}
