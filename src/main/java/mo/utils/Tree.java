package mo.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @Author: gongzhanjing
 * @Date: 2018/11/26
 */

//知识地图  基本数据结构
@Data
class KnowledgeMapNode {
    int level;      // 等级描述
    String name;    // 储存的值
    List<KnowledgeMapNode> childList;
    private long payKnowledgeMapNodeId;
    private long parentId;
}

@Data
// 知识地图操作类
class KnowledgeMapUtils {
    public List<KnowledgeMapNode> bodyList = Lists.newArrayList();

    static KnowledgeMapUtils getInstance() {
        return new KnowledgeMapUtils();
    }

    // 添加一个节点
    void put(KnowledgeMapNode knowledgeMap) {
        bodyList.add(knowledgeMap);
    }

//    // 获取指定节点的子树
//    void getTree(KnowledgeMapNode rootNode) {
//        getChild(rootNode, Maps.newHashMap());
//    }


    //    // 根据指定节点生成树
//    private void getChild(KnowledgeMapNode rootNode, Map<Long, Long> map) {
//        List<KnowledgeMapNode> childList = Lists.newArrayList();
//        bodyList.stream()
//                .filter(c -> !map.containsKey(c.getId()))
//                .filter(c -> c.getPid() == rootNode.getId())
//                .forEach(c -> {
//                    map.put(c.getId(), c.getPid());
//                    getChild(c, map);
//                    childList.add(c);
//                });
//        rootNode.setChildList(childList);
//    }
    // 获取指定节点的子树
    KnowledgeMapNode getTree2(KnowledgeMapNode rootNode) {
        Map<Long, KnowledgeMapNode> id2NodeMap = Maps.newHashMap();
        for (KnowledgeMapNode data : bodyList) {
            id2NodeMap.put(data.getPayKnowledgeMapNodeId(), data);
        }
        for (KnowledgeMapNode data : bodyList) {
            KnowledgeMapNode parent = id2NodeMap.get(data.getParentId());
            if (parent == null) {
                continue;
            }
            if (parent.getChildList() == null) {
                parent.setChildList(Lists.newArrayList());
            }
            parent.getChildList().add(data);
        }

        filterChildrenForMapNode(rootNode, Sets.newHashSet());
        return rootNode;
    }

    private void filterChildrenForMapNode(KnowledgeMapNode node, HashSet<Long> parentsIdSet) {
        parentsIdSet.add(node.getPayKnowledgeMapNodeId());
        List<KnowledgeMapNode> children = node.getChildList();
        if (children == null) {
            node.setChildList(Lists.newArrayList());
            return;
        }

        List<KnowledgeMapNode> list = Lists.newArrayList();
        children.forEach(o -> {
            if (parentsIdSet.contains(o.getPayKnowledgeMapNodeId())) {
                System.out.println("已出现在链路中 " + o.getPayKnowledgeMapNodeId() + o.getParentId());
            } else {
                list.add(o);
            }
        });

        node.setChildList(list);
        for (KnowledgeMapNode child : node.getChildList()) {
            filterChildrenForMapNode(child, parentsIdSet);
        }
        parentsIdSet.remove(node.getPayKnowledgeMapNodeId());
    }
}


class TreeDemo {
    public static void main(String[] args) {
        KnowledgeMapUtils tree = KnowledgeMapUtils.getInstance();


//        for (int i = 2; i < 8; i++) {
//            KnowledgeMapNode beanTree = new KnowledgeMapNode();
//            beanTree.setId(i);
//            beanTree.setPid(i / 2);
//            tree.put(beanTree);
//        }
//        KnowledgeMapNode rootNode2 = new KnowledgeMapNode();
////        rootNode2.setId(0);
//        tree.getTree(rootNode2);
////        System.out.println(tree.getTree(rootNode2));
//
//        KnowledgeMapNode beanTree3 = new KnowledgeMapNode();
//        beanTree3.setId(1);
//        beanTree3.setPid(9);
//        tree.put(beanTree3);
//        KnowledgeMapNode beanTree7 = new KnowledgeMapNode();
//        beanTree7.setId(9);
//        beanTree7.setPid(1);
//        tree.put(beanTree7);
//
//        System.out.println("root" + rootNode);
//        System.out.println("root" + rootNode.getChildList());
//        rootNode.getChildList().forEach(o-> System.out.println("11" + o.getChildList()));

//        KnowledgeMapNode rootNode = new KnowledgeMapNode();
//        rootNode.setId(1);
//        rootNode.setPid(0);
//        tree.put(rootNode);

        KnowledgeMapNode beanTree = new KnowledgeMapNode();
        beanTree.setParentId(1);
        beanTree.setPayKnowledgeMapNodeId(2);
        tree.put(beanTree);

        KnowledgeMapNode beanTree1 = new KnowledgeMapNode();
        beanTree1.setParentId(2);
        beanTree1.setPayKnowledgeMapNodeId(3);
        tree.put(beanTree1);


        KnowledgeMapNode beanTree2 = new KnowledgeMapNode();
        beanTree2.setParentId(2);
        beanTree2.setPayKnowledgeMapNodeId(1);
        tree.put(beanTree2);

//        tree.getTree2(beanTree);
//        System.out.println(beanTree);
        tree.getTree2(beanTree2);
        System.out.println(beanTree2);

    }
}