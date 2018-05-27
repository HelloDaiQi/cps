package com.daiqi.service.impl;

import com.daiqi.entity.CertificationUser;
import com.daiqi.entity.CertificationUserExample;
import com.daiqi.extend.CertificationUserExtends;
import com.daiqi.mapper.CertificationUserExtendsMapper;
import com.daiqi.mapper.CertificationUserMapper;
import com.daiqi.service.CertificationUserService;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "certificationUserService")
public class CertificationUserServiceImpl implements CertificationUserService {

    @Autowired
    private CertificationUserMapper certificationUserMapper;

    @Autowired
    private CertificationUserExtendsMapper certificationUserExtendsMapper;

    @Override
    public PageInfo findByPage(DataSearch dataSearch) throws Exception {
        int pageNo = dataSearch.getPage() == null?1:dataSearch.getPage();
        int pageSize = dataSearch.getLimit() == null?10:dataSearch.getLimit();
        PageHelper.startPage(pageNo, pageSize);
        CertificationUserExample example=new CertificationUserExample();
        CertificationUserExample.Criteria criteria = example.createCriteria();
        if(dataSearch.getCondition()!=null && dataSearch.getContent()!=null){
            if( dataSearch.getCondition().equals("1")){
                criteria.andCuseridEqualTo(Integer.parseInt(dataSearch.getContent()));
            }else if(dataSearch.getCondition().equals("2")){
                criteria.andRealnameLike("%"+dataSearch.getContent()+"%");
            }else if(dataSearch.getCondition().equals("3")){
                criteria.andCardnumberLike("%"+dataSearch.getContent()+"%");
            }
        }
        List<CertificationUser> list = certificationUserMapper.selectByExample(example);
        PageInfo<CertificationUser> page = new PageInfo<CertificationUser>(list);
        return page;
    }

    @Override
    public List<CertificationUser> findAll() throws Exception {
        CertificationUserExample example = new CertificationUserExample();
        List<CertificationUser> cUserList = certificationUserMapper.selectByExample(example);
        return cUserList;
    }

    @Override
    public CertificationUser findByCuserid(Integer cuserid) throws Exception {
        return certificationUserMapper.selectByPrimaryKey(cuserid);
    }

    @Override
    public List<CertificationUserExtends> findNew() throws Exception {
        List<CertificationUserExtends> certificationUserExtendsList = certificationUserExtendsMapper.selectNew();
        return certificationUserExtendsList;
    }

    @Override
    public Integer saveCuser(CertificationUser cuser) throws Exception {
        return certificationUserMapper.insertSelective(cuser);
    }

    @Override
    public Integer updateCuser(CertificationUser cuser) throws Exception {
        return certificationUserMapper.updateByPrimaryKeySelective(cuser);
    }

    @Override
    public CertificationUserExtends findExtendsByCuserid(Integer cuserid) throws Exception {
        return certificationUserExtendsMapper.selectByPrimaryKey(cuserid);
    }

    @Override
    public CertificationUser findByUserid(Integer userid) throws Exception {
        CertificationUserExample example = new CertificationUserExample();
        CertificationUserExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<CertificationUser> certificationUserList = certificationUserMapper.selectByExample(example);
        if(certificationUserList.size()==1){
            return certificationUserList.get(0);
        }
        return null;
    }

    @Override
    public Integer deleteCuser(Integer cuserid) throws Exception {
        return certificationUserMapper.deleteByPrimaryKey(cuserid);
    }

    @Override
    public Integer countByCertificationtime(Date date) throws Exception {
        CertificationUserExample example = new CertificationUserExample();
        CertificationUserExample.Criteria criteria = example.createCriteria();
        criteria.andCertificationtimeEqualTo(date);
        return certificationUserMapper.countByExample(example);
    }
}
