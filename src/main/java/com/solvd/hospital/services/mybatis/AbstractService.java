package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.util.Constants;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public abstract class AbstractService {
    private static final Logger LOG = LogManager.getLogger(AbstractService.class);

    public SqlSession sqlSession(){
        Reader reader = null;
        try{
            reader = Resources.getResourceAsReader(Constants.MYBATIS_CONFIG);
        } catch (IOException e) {
            LOG.error(e);
        }
        SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(reader);
        return sql.openSession();
    }
}
