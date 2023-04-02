package com.zhbit.dao.parkcarinfo;

import com.zhbit.pojo.Parkcarinfo;
import com.zhbit.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkcarinfoDaoImpl implements ParkcarinfoDao{

    @Override
    public List<Parkcarinfo> list(String keyword) throws SQLException {
        String sql = "select * from `parkcar_info`";
        Connection connection=DBUtils.getConnection();
        PreparedStatement pstm=null;
        ResultSet rs=null;
        Object[]  params= {};
        if(keyword!=null ){
            if( !keyword.equals("")){
                sql=sql+"  where parkNo like '%"+keyword+"%'";
            }
        }
        rs =DBUtils.execute(connection,pstm,rs,sql,params);
        List<Parkcarinfo> list=new ArrayList<Parkcarinfo>();
        while (rs.next()){
            Parkcarinfo parkcarinfo = new Parkcarinfo();
            parkcarinfo.setParkNo(rs.getInt("parkNo"));
            parkcarinfo.setAllspace(rs.getInt("allspace"));
            parkcarinfo.setOccupied(rs.getInt("occupied"));
            list.add(parkcarinfo);
        }
        return list;
    }

    @Override
    public int delete(Integer parkNo) throws SQLException {
        String sql = "delete from `parkcar_info` where parkNo = ?";
        Connection connection = DBUtils.getConnection();
        PreparedStatement pstm = null;
        Object[] params = {parkNo};
        int delete = DBUtils.update(connection, sql, params, pstm);
        return delete;
    }
    @Override
    public Parkcarinfo findById(Integer parkNo) throws SQLException {
        String sql = "select * from `parkcar_info` where parkNo = ?";
        Connection connection = DBUtils.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs =null;
        Object[] params = {parkNo};
        rs = DBUtils.execute(connection, pstm, rs, sql, params);

        if (rs.next()) {
            Parkcarinfo parkcarinfo = new Parkcarinfo();
            parkcarinfo.setParkNo(rs.getInt("parkNo"));
            parkcarinfo.setAllspace(rs.getInt("allspace"));
            parkcarinfo.setOccupied(rs.getInt("occupied"));
            return parkcarinfo;

        }
        return null;
    }

    @Override
    public int updateById(Parkcarinfo parkcarinfo) throws SQLException {
        String sql = "UPDATE `parkcar_info` SET `allspace` = ?, `occupied` = ? WHERE `parkNo` = ?";
        Connection connection = DBUtils.getConnection();
        PreparedStatement pstm = null;
        Object[] params = {parkcarinfo.getAllspace(), parkcarinfo.getOccupied(), parkcarinfo.getParkNo()};
        int update = DBUtils.update(connection, sql, params, pstm);
        return update;
    }

    @Override
    public int create(Parkcarinfo parkcarinfo) throws SQLException {
        String sql = "INSERT INTO `parkcar_info`(`allspace`, `occupied`) VALUES (?, ?)";
        Connection connection = DBUtils.getConnection();
        PreparedStatement pstm = null;
        Object[] params = {parkcarinfo.getAllspace(), parkcarinfo.getOccupied()};
        int create = DBUtils.update(connection, sql, params, pstm);
        return create;
    }
}
