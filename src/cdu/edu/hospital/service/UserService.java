package cdu.edu.hospital.service;

import java.util.List;

import cdu.edu.hospital.entity.User;
import cdu.edu.hospital.entity.UserCode;

/**
 * �û��ķ���ӿ�
 * @author ��
 *
 */
public interface UserService {
	//�û��ĵ�¼
	public User login(String id,String password) throws NameOrPasswordException;
	//�û���ע��
	public void register(User user);
	//�û��Ĳ�ѯ
	public User findUserById(String id);
	//�û��Ĳ�ѯ
	public List<User> userQuery(UserCode userCode);
	//�û���ɾ��
	public void userDelete(String id);
	//�޸�����
	public void updateUser(User user);
	//�����û���Ϣ
	public void updateUserMessage(User user);
}
