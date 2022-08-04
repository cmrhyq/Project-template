package cn.topic.queue.tree;

/**
 * <h1 style="color:white">在二叉树中增加一行</h1>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot cn.topic.queue.tree.AddTreeNode
 * @date 2022/8/5-1:00
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class AddTreeNode {

    /**
     * <h2 style="color:white">深度优先</h2>
     * <div>
     *     <p>当输入的depth为1时</p>
     *     <div style="margin:0 0 0 10px">
     *          此时需要创建一个新的root，然后将原来的root作为新root的左子节点。
     *     </div>
     *     <p>当输入的depth为2时</p>
     *     <div style="margin:0 0 0 10px">
     *         需要在root下新增两个节点left和right作为root的新子节点，并把原来的左子节点作为新left的左子节点，把原来的右子节点作为新right的右子节点
     *     </div>
     *     <p>当depth大于2时</p>
     *     <div style="margin:0 0 0 10px">
     *         需要一直递归往下搜索，并将depth减1，直到depth等于2.
     *     </div>
     * </div>
     * @param root 树
     * @param val 值
     * @param depth 深度
     * @return TreeNode
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        } else if (depth == 1) {
            return new TreeNode(val, root, null);
        } else if (depth == 2) {
            root.left = new TreeNode(val,root.left,null);
            root.right = new TreeNode(val,null,root.right);
        } else {
            root.left = addOneRow(root.left,val,depth-1);
            root.right = addOneRow(root.right,val,depth-1);
        }
        return root;
    }
}
