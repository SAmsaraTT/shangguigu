package cn.atguigu.team.junit;

import cn.atguigu.team.domain.Employee;
import cn.atguigu.team.service.NameListService;
import cn.atguigu.team.service.TeamException;
import org.junit.jupiter.api.Test;

public class NameListServiceTest {
    @Test
    public void testGetAllEmployees() {
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmployees();

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testGetEmployee() {
        NameListService nameListService = new NameListService();
        int id = 101;

        try {
            Employee employee = nameListService.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            throw new RuntimeException(e);
        }
    }
}
