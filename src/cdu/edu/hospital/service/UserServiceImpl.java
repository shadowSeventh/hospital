package cdu.edu.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cdu.edu.hospital.dao.UserDao;
import cdu.edu.hospital.entity.User;
import cdu.edu.hospital.entity.UserCode;
import cdu.edu.hospital.service.NameOrPasswordException;
import cdu.edu.hospital.service.UserService;


/**
 * ҵ���ʵ����
 * @Service �����ɨ�����, ɨ�赽cdu.edu.hospital.impl
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired //ע������ID�� userDao
	private UserDao userDao;
	
	@Transactional
	public User login(String name, String password) throws NameOrPasswordException {
		//�����ڲ���!!! 
		if(name==null||name.trim().isEmpty()){
			throw new NameOrPasswordException(1, "�û�Ϊ��");
		}
		if(password==null||password.trim().isEmpty()){
			throw new NameOrPasswordException(2, "����Ϊ��");
		}
		name = name.trim();
		password = password.trim();
		User useryz = new User();
		useryz.setId(name);
		User user = userDao.findUserById(name);
		if(user==null){
			throw new NameOrPasswordException(1, "�û�������");
		}
		/*if(! name.equals(user.getName())){
			throw new NameOrPasswordException(1,"���ִ���");
		}*/
		if(user!=null&&password.equals(user.getPassword())){
			//��¼�ɹ�
			return user;
		}
		System.out.println("�������");
		throw new NameOrPasswordException(2, "�������");
	}

	/**
	 * �û�ע��
	 */
	@Override
	public void register(User user) {
		userDao.saveUser(user);
	}
	/**
	 * �û���ѯ
	 */
	@Override
	public User findUserById(String id) {
		return userDao.findUserById(id);
	}
	/**
	 * �û��Ĳ�ѯ
	 */
	@Override
	public List<User> userQuery(UserCode userCode) {
		return userDao.userQuery(userCode);
	}
	/**
	 * �û���ɾ��
	 */
	@Override
	public void userDelete(String id) {
		 userDao.userDelete(id);
	}
	/**
	 * �޸�����
	 */
	@Override
	public void updateUser(User user) {
		 userDao.updateUser(user);
	}
	/**
	 * �޸��û���Ϣ
	 */
	@Override
	public void updateUserMessage(User user) {
		 userDao.updateUserMessage(user);
	}
	
}



