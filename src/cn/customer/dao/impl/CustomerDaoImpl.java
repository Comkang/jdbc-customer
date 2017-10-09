package cn.customer.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.customer.dao.CustomerDao;
import cn.customer.domain.Customer;
import cn.customer.domain.PageResult;
import cn.customer.exception.DaoException;
import cn.customer.utils.JdbcUtils;

/**
 * 客户管理的dao层，负责操作数据库
 * @author Administrator
 *
 */
public class CustomerDaoImpl implements CustomerDao {
    
    //1.新增一个客户
    @Override
    public void add(Customer c) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            String sql = "insert into customer(id,customerName,sex,birthday,email,hobbies,type,remark) values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getId());
            ps.setString(2, c.getCustomerName());
            ps.setString(3, c.getSex());
            ps.setDate(4, new Date(c.getBirthday().getTime()));
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getHobbies());
            ps.setString(7, c.getType());
            ps.setString(8, c.getRemark());
            ps.executeUpdate();
        } catch (Exception e) {
            //抛出一个运行时异常，如果发生异常，说明add不成功
            throw new DaoException(e);
        } finally {
            JdbcUtils.release(rs, ps, con);
        }
                
    }
    
    //2.修改一个客户
    @Override
    public void  update(Customer c) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            String sql = "update customer set customerName = ?, sex = ?, birthday = ?, email = ?, hobbies = ?, type = ?, remark = ? where id = ?";
            ps = con.prepareStatement(sql);
            ps = con.prepareStatement(sql);
            
            ps.setString(1, c.getCustomerName());
            ps.setString(2, c.getSex());
            ps.setDate(3, new Date(c.getBirthday().getTime()));
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getHobbies());
            ps.setString(6, c.getType());
            ps.setString(7, c.getRemark());
            ps.setString(8, c.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            //抛出一个运行时异常，如果发生异常，说明修改不成功
            throw new DaoException(e);
        } finally {
            JdbcUtils.release(rs, ps, con);
        }
    }
    
    //3.删除一个客户
    @Override
    public void delete(String id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            String sql = "delete from customer where id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            //抛出一个运行时异常，如果发生异常，说明删除不成功
            throw new DaoException(e);
        } finally {
            JdbcUtils.release(rs, ps, con);
        }
    }
    
    //4.查询一个客户
    @Override
    public Customer find(String id) {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = JdbcUtils.getConnection();
            String sql = "select * from customer where id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getString("id"));
                c.setCustomerName(rs.getString("customerName"));
                c.setSex(rs.getString("sex"));
                c.setBirthday(rs.getDate("birthday"));
                c.setEmail(rs.getString("email"));
                c.setHobbies(rs.getString("hobbies"));
                c.setType(rs.getString("type"));
                c.setRemark(rs.getString("remark"));
                return c;
            }
            return null;
        } catch (Exception e) {
            //抛出一个运行时异常，如果发生异常，说明查询不成功
            throw new DaoException(e);
        } finally {
            JdbcUtils.release(rs, ps, con);
        }
    }
    
    //5.查询所有的客户
    @Override
    public List<Customer> findAll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Customer> list = new ArrayList<Customer>();
            con = JdbcUtils.getConnection();
            String sql = "select * from customer";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getString("id"));
                c.setCustomerName(rs.getString("customerName"));
                c.setSex(rs.getString("sex"));
                c.setBirthday(rs.getDate("birthday"));
                c.setEmail(rs.getString("email"));
                c.setHobbies(rs.getString("hobbies"));
                c.setType(rs.getString("type"));
                c.setRemark(rs.getString("remark"));
                list.add(c);
            }
            return list;
        } catch (Exception e) {
            //抛出一个运行时异常，如果发生异常，说明查找所有客户不成功
            throw new DaoException(e);
        } finally {
            JdbcUtils.release(rs, ps, con);
        }
    }
    /**
     * 6.查询分页信息
     * @param startIndex 开始记录数
     * @param pageSize 每页显示数
     * @author Administrator
     * 
     */
    @Override
    public PageResult getPageResult(int startIndex, int pageSize) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取结果集
            List<Customer> list = new ArrayList<Customer>();
            con = JdbcUtils.getConnection();
            String sql = "select * from customer limit ?,?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, startIndex);
            ps.setInt(2, pageSize);
            rs = ps.executeQuery();
            while(rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getString("id"));
                c.setCustomerName(rs.getString("customerName"));
                c.setSex(rs.getString("sex"));
                c.setBirthday(rs.getDate("birthday"));
                c.setEmail(rs.getString("email"));
                c.setHobbies(rs.getString("hobbies"));
                c.setType(rs.getString("type"));
                c.setRemark(rs.getString("remark"));
                list.add(c);
            }
            PageResult pr = new PageResult();
            pr.setList(list);
            //获取总记录数
            String totalSql = "select count(*) from customer";
            ps = con.prepareStatement(totalSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int totalRecord = rs.getInt(1);
                pr.setTotalRecord(totalRecord);
            }
            return pr;
        } catch (Exception e) {
            //抛出一个运行时异常，如果发生异常，说明查找所有客户不成功
            throw new DaoException(e);
        } finally {
            JdbcUtils.release(rs, ps, con);
        }
    }
}
