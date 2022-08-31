package test;

import logic.controller.applicationcontroller.RegisterController;
import logic.engineeringclasses.bean.UserBean;
import logic.model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {

    private final RegisterController regController = new RegisterController();
    private final UserBean bean = new UserBean();

    @Test
    public void testRegistrationAlreadyExist(){
        int code = 0;
        bean.setUsrEmail("davide.leo@gmail.com");
        bean.setUsrAddr("Via del Corso 22");
        try {
            regController.checkRegistration(bean.getUsrEmail(), bean.getUsrAddr());
        }catch (Exception e){
            code = 1;
        }
        assertEquals(0,code);
    }

    @Test
    public void testAddRegistration(){
        int code = 0;
        bean.setUsrEmail("davide.leo@gmail.com");
        bean.setUsrPwd("davide");
        bean.setUsrAddr("Via del Corso 22");
        User user = new User(null,"resident",bean.getUsrEmail(),bean.getUsrPwd(),bean.getUsrAddr());
        bean.setUsrRole("RESIDENT");
        bean.setUsrName("resident");

        try {
            regController.addRegistrationUser(user, bean.getUsrRole(), bean.getUsrName());
        }catch (Exception e){
            code = 1;
        }
        assertEquals(0,code);
    }

    @Test
    public void testRemoveRegistered(){
        int code = 0;
        bean.setUsrID("57");
        try {
            regController.removeRegistered(Integer.parseInt(bean.getUsrID()));
        }catch (Exception e){
            code = 1;
        }
        assertEquals(0,code);
    }


}
