package com.ttq.client;

import java.util.List;
import java.util.Scanner;

import com.ttq.entity.*;
import com.ttq.service.AdministratorService;
import com.ttq.service.UserService;
import com.ttq.service.Impl.AdministratorServiceImpl;
import com.ttq.service.Impl.UserServiceImpl;

public class Client {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UserService userService = new UserServiceImpl();
		AdministratorService administratorService = new AdministratorServiceImpl();
		System.out.println("*************欢迎进入夕阳帮扶系统*************");
		while (true) {
			menu(scanner, userService, administratorService);
		}

	}

	public static void menu(Scanner scanner, UserService userService, AdministratorService administratorService) {
		// TODO Auto-generated method stub
		System.out.println("1.管理员*");
		System.out.println("2.用  户*");
		System.out.println("***************************************");
		System.out.println("请输入您的选择:");
		int choice = Integer.parseInt(scanner.nextLine().trim());
		switch (choice) {
		case 1:
			adminMenu(scanner, administratorService);
			break;
		case 2:
			userMenu(scanner, userService);
			break;

		default:
			System.out.println("您输入的有误");
			break;
		}

	}

	private static void userMenu(Scanner scanner, UserService userService) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1.登录");
			System.out.println("2.注册");
			System.out.println("请输入您的选择:");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				System.out.println("请输入用户名:");
				String userName = scanner.nextLine().trim();
				System.out.println("请输入密码:");
				String password = scanner.nextLine().trim();
				User user = userService.login(userName, password);
				int userId = user.getId();
				if (user != null) {
					userSecondMenu(scanner, userService, userId);
				} else {
					System.out.println("用户名或密码错误");
				}
				break;

			case 2:
				System.out.println("请输入真实姓名:");
				String name = scanner.nextLine().trim();
				System.out.println("请输入用户名");
				userName = scanner.nextLine().trim();
				System.out.println("请输入密码:");
				password = scanner.nextLine().trim();
				System.out.println("请输入性别:");
				String sex = scanner.nextLine().trim();
				System.out.println("请输入年龄:");
				int age = Integer.parseInt(scanner.nextLine().trim());
				System.out.println("请输入电话:");
				int phone = Integer.parseInt(scanner.nextLine().trim());
				String code = (Math.random() + "").substring(2, 8);
				System.out.println("请输入验证码:" + code);
				String code1 = scanner.nextLine().trim();
				if (code1.equals(code)) {
					boolean flag = userService.register(new User(null, name, userName, password, sex, age, phone));
					if (flag) {
						System.out.println("注册正确");
					} else {
						System.out.println("注册失败");
					}
				} else {
					System.out.println("验证码输入不正确");
				}
				break;

			default:
				System.out.println("您输入的不正确");
				break;
			}
		}
	}

	private static void userSecondMenu(Scanner scanner, UserService userService, int userId) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1.查看需要帮扶的老人信息");
			System.out.println("2.帮扶老人");
			System.out.println("3.记录帮扶事件");
			System.out.println("4.查看自己的帮扶事件");
			System.out.println("5.退出");
			System.out.println("请输入您的选择:");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				List<OldNoHelp> noHelpList = userService.showNeedHelpOld();
				System.out.println("**********************************************");
				System.out.println("需要帮扶老人列表");
				System.out.println("id\t老人姓名\t年龄\t性别\t地址\t联系方式");
				for (OldNoHelp oldNoHelp : noHelpList) {
					System.out.println(oldNoHelp);
				}
				System.out.println("**********************************************");
				break;
			case 2:
				System.out.println("选择需要帮扶老人的id号:");
				int oldId = Integer.parseInt(scanner.nextLine().trim());
				boolean flag = userService.addHelpOld(oldId, userId);
				if (flag) {
					System.out.println("帮扶正确");
				} else {
					System.out.println("帮扶失败");
				}
				break;
			case 3:
				System.out.println("选择需要帮扶老人的id号:");
				oldId = Integer.parseInt(scanner.nextLine().trim());
				System.out.println("请输入帮扶的事情详情:");
				String helpDescription = scanner.nextLine().trim();
				flag = userService.addHelp(userId, oldId, helpDescription);
				if (flag) {
					System.out.println("添加成功");
				} else {
					System.out.println("添加失败");
				}
				break;
			case 4:
				List<HelpPrint> helpList = userService.showHelp(userId);
				for (HelpPrint helpPrint : helpList) {
					System.out.println(helpPrint);
				}
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("您输入的不正确");
				break;
			}
		}
	}

	private static void adminMenu(Scanner scanner, AdministratorService administratorService) {
		// TODO Auto-generated method stub
		System.out.println("1.登录");
		System.out.println("2.注册");
		System.out.println("请输入您的选择:");
		int choice = Integer.parseInt(scanner.nextLine().trim());
		switch (choice) {
		case 1:
			System.out.println("请输入用户名:");
			String adminName = scanner.nextLine().trim();
			System.out.println("请输入密码:");
			String password = scanner.nextLine().trim();
			Administrator administrator = administratorService.login(adminName, password);
			if (administrator != null) {
				adminSecondMenu(scanner, administratorService);
			} else {
				System.out.println("用户名或密码错误");
			}
			break;
		case 2:
			System.out.println("请输入用户名:");
			adminName = scanner.nextLine().trim();
			System.out.println("请输入密码:");
			password = scanner.nextLine().trim();
			String code = (Math.random() + "").substring(2, 8);
			System.out.println("请输入验证码:" + code);
			String code1 = scanner.nextLine().trim();
			if (code1.equals(code)) {
				boolean flag = administratorService.register(new Administrator(null, adminName, password));
				if (flag) {
					System.out.println("注册正确");
				} else {
					System.out.println("注册失败");
				}
			} else {
				System.out.println("验证码输入不正确");
			}
			break;
		default:
			System.out.println("您输入的有误");
			break;
		}
	}

	private static void adminSecondMenu(Scanner scanner, AdministratorService administratorService) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1.录入老人信息");
			System.out.println("2.查看老人信息");
			System.out.println("3.删除老人信息");
			System.out.println("4.修改老人信息");
			System.out.println("5.退出");
			System.out.println("请输入您的选择:");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				System.out.println("请输入老人的姓名:");
				String oldname = scanner.nextLine().trim();
				System.out.println("请输入老人的年龄:");
				int oldage = Integer.parseInt(scanner.nextLine().trim());
				System.out.println("请输入老人的地址:");
				String address = scanner.nextLine().trim();
				System.out.println("请输入老人的性别:");
				String oldsex = scanner.nextLine().trim();
				System.out.println("请输入联系方式:");
				String contact = scanner.nextLine().trim();
				boolean flag = administratorService
						.addOld(new Old(null, oldname, oldsex, oldage, address, contact, null));
				if (flag) {
					System.out.println("添加成功");
				} else {
					System.out.println("添加失败");
				}
				break;
			case 2:
				List<OldAdminPrint> allOldList = administratorService.showOld();
				System.out.println("***********************************");
				System.out.println("老人列表");
				System.out.println("老人姓名\t年龄\t姓名\t地址\t联系方式");
				for (OldAdminPrint oldAdminPrint : allOldList) {
					System.out.println(oldAdminPrint.getOldName() + "\t" + oldAdminPrint.getOldAge() + "\t"
							+ oldAdminPrint.getOldSex() + "\t" + oldAdminPrint.getAddress() + "\t"
							+ oldAdminPrint.getContact());
				}
				System.out.println("***********************************");
				break;
			case 3:
				System.out.println("请输入要删除的老人ID:");
				int oldId = Integer.parseInt(scanner.nextLine().trim());
				flag = administratorService.deleteOld(oldId);
				if (flag) {
					System.out.println("删除成功");
				} else {
					System.out.println("删除失败");
				}
				break;
			case 4:
				int oldAge = 0;
				System.out.println("请输入修改老人的ID号:");
				oldId = Integer.parseInt(scanner.nextLine().trim());
				Old old = administratorService.selectOldById(oldId);
				System.out.println("是否修改年龄(Y/N)");
				String cho = scanner.nextLine().trim();
				if (cho.equals("Y")) {
					System.out.println("请输入新的年龄：");
					oldAge = Integer.parseInt(scanner.nextLine().trim());
				} else {
					oldAge = old.getOldAge();
				}
				System.out.println("是否修改地址(Y/N)");
				cho = scanner.nextLine().trim();
				if (cho.equals("Y")) {
					System.out.println("请输入新的地址：");
					address = scanner.nextLine().trim();
				} else {
					address = old.getAddress();
				}
				System.out.println("是否修改联系方式(Y/N)");
				cho = scanner.nextLine().trim();
				if (cho.equals("Y")) {
					System.out.println("请输入新的联系方式：");
					contact = scanner.nextLine().trim();
				} else {
					contact = old.getContact();
				}
				flag = administratorService.updateOld(oldId, oldAge, address, contact);
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("您输入的有误");
				break;
			}
		}
	}
}
