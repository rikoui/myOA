package com.bjdreamtech.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.bean.DMTResultBean;
import com.bjdreamtech.dmt.bean.DMTSessionBean;
import com.bjdreamtech.dmt.format.DMTTimeFormatter;
import com.bjdreamtech.dmt.util.DMTDateUtil;
import com.bjdreamtech.dmt.util.DMTPrimaryKeyUtil;
import com.bjdreamtech.dmt.util.DMTSqlTransferUtil;
import com.bjdreamtech.entity.SysParam;
import com.bjdreamtech.entity.SysParamExample;
import com.bjdreamtech.format.DMTStatusFormatter;
import com.bjdreamtech.mapper.auto.SysParamMapper;
import com.bjdreamtech.mapper.custom.ParamManageMapper;
import com.bjdreamtech.service.IParamManageService;

/**
 * 参数管理业务层实现类
 * @author duanwu
 *
 */
@Service("paramManageService")
public class ParamManageServiceImpl extends BaseServiceImpl implements IParamManageService{
	
	@Resource
	ParamManageMapper paramManageMapper;
	@Resource
	SysParamMapper paramMapper;

	/**
	 * 分页查询参数数据
	 */
	@Override
	public DMTDataTableBean<Map<String, Object>> queryParamListByPage(
			HttpServletRequest request) {
		//初始化分页参数
		initPageParameter(request);
		//获取模糊查询条件：参数代码
		String code = request.getParameter("code");
		//获取模糊查询条件：参数键
		String key = request.getParameter("key");
		//获取模糊查询条件：参数值
		String value = request.getParameter("value");
		//获取精确查询条件：状态
		String status = request.getParameter("status");
		if(notNull(code)){
			//添加经过转义后的模糊查询条件
			params.put("code", DMTSqlTransferUtil.transfer(code));
		}
		if(notNull(key)){
			//添加经过转义后的模糊查询条件
			params.put("key", DMTSqlTransferUtil.transfer(key));
		}
		if(notNull(value)){
			//添加经过转义后的模糊查询条件
			params.put("value", DMTSqlTransferUtil.transfer(value));
		}
		if(notNull(status)){
			//添加精确查询条件
			params.put("status", status);
		}
		List<Map<String,Object>> paramList = paramManageMapper.queryParamListByPage(params);
		DMTTimeFormatter.formatTimeList(paramList, "createtime", "createtimecopy");
		DMTStatusFormatter.formatStatusList(paramList, "status", "statuscopy", "SIMPLE_STATUS",paramManageMapper);
		return new DMTDataTableBean<Map<String,Object>>(pageUtil.getTotalCount(),paramList);
	}

	/**
	 * 新增参数
	 */
	@Override
	public DMTResultBean addParam(HttpServletRequest request) {
		DMTSessionBean userinfo = (DMTSessionBean)request.getSession().getAttribute("sessionBean");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String key = request.getParameter("key");
		String value = request.getParameter("value");
		String description = request.getParameter("description");
		if(!validateAddParam(code,key,value,description)){
			return new DMTResultBean("1","数据校验失败","");
		}
		//判断是否已存在相同的参数代码和参数键数据
		SysParamExample spe = new SysParamExample();
		spe.createCriteria().andParamCodeEqualTo(code).andParamKeyEqualTo(key);
		List<SysParam> paramList = paramMapper.selectByExample(spe);
		if(paramList!=null&&paramList.size()>0){
			return new DMTResultBean("1","已存在相同参数代码和参数键的参数","");
		}
		//设置参数数据
		SysParam param = new SysParam();
		param.setParamCode(code);
		param.setParamName(name);
		param.setParamCreatetime(DMTDateUtil.parseDate());
		param.setParamDescription(description);
		param.setParamId(DMTPrimaryKeyUtil.getPrimaryKey("P"));
		param.setParamKey(key);
		param.setParamStatus("0");
		param.setParamValue(value);
		//保存参数
		paramMapper.insertSelective(param);
		log.logging("新增系统参数", this.getClass(), userinfo.getUsername(), userinfo.getIp());
		return new DMTResultBean();
	}
	
	public boolean validateAddParam(String code,String key,String value,String description){
		if(isNull(code)||isNull(key)||isNull(value)){
			return false;
		}
		if(code.length()>20||key.length()>10||value.length()>100){
			return false;
		}
		if(notNull(description)&&description.length()>50){
			return false;
		}
		return true;
	}

	/**
	 * 根据参数ID获取参数详情
	 */
	@Override
	public DMTResultBean getParamInfo(HttpServletRequest request) {
		String paramid = request.getParameter("paramid");
		SysParam param = paramMapper.selectByPrimaryKey(paramid);
		if(param==null){
			return new DMTResultBean("1","该参数已不存在","");
		}
		return new DMTResultBean("0","",param);
	}

	/**
	 * 修改参数信息
	 */
	@Override
	public DMTResultBean editParam(HttpServletRequest request) {
		DMTSessionBean userinfo = (DMTSessionBean)request.getSession().getAttribute("sessionBean");
		String id = request.getParameter("id");
		String code = request.getParameter("code");
		String key = request.getParameter("key");
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		String status = request.getParameter("status");
		String description = request.getParameter("description");
		if(!validateEditParam(id,code,key,value,status,description,name)){
			new DMTResultBean("1","数据校验失败","");
		}
		//判断是否存在相同code和key的参数
		SysParamExample spe = new SysParamExample();
		spe.createCriteria().andParamCodeEqualTo(code).andParamKeyEqualTo(key).andParamIdNotEqualTo(id);
		List<SysParam> paramList = paramMapper.selectByExample(spe);
		if(paramList!=null&&paramList.size()>0){
			return new DMTResultBean("1","已存在相同参数代码和参数键的参数","");
		}
		SysParam param = paramMapper.selectByPrimaryKey(id);
		if(param==null){
			return new DMTResultBean("1","该参数已不存在","");
		}
		param.setParamCode(code);
		param.setParamDescription(description);
		param.setParamKey(key);
		param.setParamStatus(status);
		param.setParamValue(value);
		paramMapper.updateByPrimaryKeySelective(param);
		log.logging("修改系统参数", this.getClass(), userinfo.getUsername(), userinfo.getIp());
		return new DMTResultBean();
	}
	
	/**
	 * 校验编辑参数数据
	 * @param id
	 * @param code
	 * @param key
	 * @param value
	 * @param status
	 * @param description
	 * @return
	 */
	public boolean validateEditParam(String id,String code,String key,String value,String status,String description,String name){
		if(isNull(id)||isNull(code)||isNull(key)||isNull(value)||isNull(status)||isNull(name)){
			return false;
		}
		if(code.length()>20||key.length()>10||value.length()>100||status.length()>1){
			return false;
		}
		if(notNull(description)&&description.length()>50){
			return false;
		}
		return true;
	}

	/**
	 * 删除参数信息
	 */
	@Override
	public DMTResultBean deleteParam(HttpServletRequest request) {
		DMTSessionBean userinfo = (DMTSessionBean)request.getSession().getAttribute("sessionBean");
		String id = request.getParameter("id");
		int res = paramMapper.deleteByPrimaryKey(id);
		if(res==0){
			return new DMTResultBean("1","该参数已不存在","");
		}
		log.logging("删除系统参数", this.getClass(), userinfo.getUsername(), userinfo.getIp());
		return new DMTResultBean();
	}

	/**
	 * 启用或者禁用参数
	 */
	@Override
	public DMTResultBean statusParam(HttpServletRequest request) {
		DMTSessionBean userinfo = (DMTSessionBean)request.getSession().getAttribute("sessionBean");
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		SysParam param = paramMapper.selectByPrimaryKey(id);
		if(param==null){
			new DMTResultBean("1","改参数已不存在","");
		}
		param.setParamStatus(status);
		paramMapper.updateByPrimaryKeySelective(param);
		if(status.equals("0")){
			log.logging("启用系统参数", this.getClass(), userinfo.getUsername(), userinfo.getIp());
			return new DMTResultBean("0","","启用参数成功");
		}
		log.logging("禁用系统参数", this.getClass(), userinfo.getUsername(), userinfo.getIp());
		return new DMTResultBean("0","","禁用参数成功");
	}

	/**
	 * 批量删除参数数据
	 */
	@Override
	public DMTResultBean paramDeleteBatch(HttpServletRequest request) {
		DMTSessionBean userinfo = (DMTSessionBean)request.getSession().getAttribute("sessionBean");
		String ids = request.getParameter("ids");
		String[] idarr = ids.split(";");
		for(int i=0;i<idarr.length;i++){
			paramMapper.deleteByPrimaryKey(idarr[i]);
		}
		log.logging("批量删除系统参数", this.getClass(), userinfo.getUsername(), userinfo.getIp());
		return new DMTResultBean();
	}

	/**
	 * 根据参数代码获取key-value对
	 */
	@Override
	public DMTResultBean findParamByCode(HttpServletRequest request) {
		String code = request.getParameter("code");
		//根据参数代码查询所有数据
		List<Map<String,String>> paramList = paramManageMapper.getParamByCode(code);
		return new DMTResultBean("0","",paramList);
	}
	
	/**
	 * 查询系统下的所有核心企业
	 */
	@Override
	public DMTResultBean findCompanyByCode(HttpServletRequest request) {
		//根据参数代码查询所有数据
		List<Map<String,String>> paramList = paramManageMapper.getCompanyByCode();
		return new DMTResultBean("0","",paramList);
	}
	
	/**
	 * 查询系统下的所有资方
	 */
	@Override
	public DMTResultBean findCapitalByCode(HttpServletRequest request) {
		//根据参数代码查询所有数据
		List<Map<String,String>> paramList = paramManageMapper.getCapitalByCode();
		return new DMTResultBean("0","",paramList);
	}
	
}
