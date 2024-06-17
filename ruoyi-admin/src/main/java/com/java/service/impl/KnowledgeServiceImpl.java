package com.java.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.entity.MsKnowledge;
import com.java.entity.vo.knowledge.MsKnowledgeTreeVo;
import com.java.mapper.MsKnowledgeMapper;
import com.java.service.IKnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeServiceImpl extends ServiceImpl<MsKnowledgeMapper, MsKnowledge> implements
        IKnowledgeService {

    @Autowired
    MsKnowledgeMapper msKnowledgeMapper;


    @Override
    public List<MsKnowledgeTreeVo> list(Integer subjectId) {
        //根据subjectId拿到所有根节点
        List<MsKnowledgeTreeVo> msKnowledgeTreeVos = msKnowledgeMapper.getRoot(subjectId);

        //msKnowledges里面是二级节点
        recursion(msKnowledgeTreeVos);
        return msKnowledgeTreeVos;
    }

    public void recursion(List<MsKnowledgeTreeVo> list){
        if (list == null) return;
        for (MsKnowledgeTreeVo msKnowledge : list) {
            //拿到根节点的id
            Integer parentId = msKnowledge.getKnowledgeId();
            List<MsKnowledgeTreeVo> child = msKnowledgeMapper.getChild(parentId);
            msKnowledge.setChild(child);
            recursion(child);
        }
    }

}
