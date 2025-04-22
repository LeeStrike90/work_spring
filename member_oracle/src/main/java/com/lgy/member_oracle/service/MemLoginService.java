package com.lgy.member_oracle.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lgy.member_oracle.dao.MemDAO;

@Service  // �� Ŭ������ ���� �������� Spring���� �˷��ִ� ������̼� (�ڵ� ��ϵ�)
public class MemLoginService implements MemService
{
	/**
	 * �α��� ó���� ���� �޼���
	 * ��Ʈ�ѷ����� �ѱ� model �ȿ� ��� �ִ� request ��ü�κ��� ����� �Է°��� ������
	 * DAO�� ���� DB�� �α��� ���θ� Ȯ���� ��, ���(int)�� ��ȯ
	 *
	 * @param model JSP���� �Ѱܹ��� ����� �Է°�(HttpServletRequest ����)
	 * @return �α��� ���� ���θ� int�� ��ȯ (1: ����, 0: ��� Ʋ��, -1: ���̵� ����)
	 */
	@Override
	public int excute(Model model)
	{
		// model �ȿ� �ִ� ������ Map �������� ��ȯ
		Map<String, Object> map = model.asMap();

		// model�� ����ִ� request ��ü�� ������ ��� (��Ʈ�ѷ����� addAttribute�� �ѱ�)
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		// ����ڷκ��� �Է¹��� ���̵�� ��й�ȣ�� ������
		String mId = request.getParameter("mem_uid");  // �� name="mem_uid"
		String mPw = request.getParameter("mem_pwd");  // �� name="mem_pwd"

		// DB �۾��� ���� DAO ��ü ����
		MemDAO dao = new MemDAO();

		// DAO�� loginYn() �޼��带 ȣ���Ͽ� �α��� ���� Ȯ��
		// ����� 1(����), 0(��й�ȣ Ʋ��), -1(���̵� ����)
		int re = dao.loginYn(mId, mPw);

		// ��Ʈ�ѷ��� ����� ����
		return re;
	}
}
