package day1108.test1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString

@Data

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor // �ʿ��� ���ڸ� �����ڷ� ����
public class TestDto {
	

	private String name;
	@NonNull
	private String addr;
	private int age;

	
}
