package structure;

import org.junit.Assert;
import org.junit.Test;

import structure.Tree.Empty;
import structure.Tree.InternalNode;
import structure.Tree.LeafNode;
import structure.Tree.Node;

public class TreeTest {

    @Test
    public void depth_노드가_존재하는_경우_가장_깊은_깊이를_반환() throws Exception {
        // given
        Node node = new InternalNode(
                new LeafNode(3),
                new InternalNode(
                        new InternalNode(
                                new LeafNode(4),
                                new LeafNode(5)),
                        new LeafNode(6)));

        // then
        Assert.assertEquals(4, node.depth());
        Assert.assertEquals(4, Tree.depth(node));
    }

    @Test
    public void depth_비어있는_경우() throws Exception {
        // given
        Node node = new Empty();

        // then
        Assert.assertEquals(0, node.depth());
        Assert.assertEquals(0, Tree.depth(node));
    }

    @Test
    public void contains_자기자신_혹은_자식노드들중_하나라도_값이_동일하면_포함되었다고_간주함() throws Exception {
        // given
        Node node = new InternalNode(
                new LeafNode(3),
                new InternalNode(
                        new InternalNode(
                                new LeafNode(4),
                                new LeafNode(5)),
                        new LeafNode(6)));

        // then
        Assert.assertFalse(node.contains(1));
        Assert.assertFalse(node.contains(2));
        Assert.assertTrue(node.contains(3));
        Assert.assertTrue(node.contains(4));
        Assert.assertTrue(node.contains(5));
        Assert.assertTrue(node.contains(6));
        Assert.assertFalse(node.contains(7));
        Assert.assertFalse(Tree.contains(node, 1));
        Assert.assertFalse(Tree.contains(node, 2));
        Assert.assertTrue(Tree.contains(node, 3));
        Assert.assertTrue(Tree.contains(node, 4));
        Assert.assertTrue(Tree.contains(node, 5));
        Assert.assertTrue(Tree.contains(node, 6));
        Assert.assertFalse(Tree.contains(node, 7));
    }

    @Test
    public void occurence_자기자신_혹은_자식노드들중_주어진_값을_가진_것들의_총_갯수를_반환한다() throws Exception {
        // given
        Node node = new InternalNode(
                new LeafNode(3),
                new InternalNode(
                        new InternalNode(
                                new LeafNode(4),
                                new LeafNode(5)),
                        new InternalNode(
                                new InternalNode(
                                        new LeafNode(4),
                                        new LeafNode(5)
                                ),
                                new LeafNode(6)
                        )));

        // then
        Assert.assertEquals(0, node.occurrence(2));
        Assert.assertEquals(1, node.occurrence(3));
        Assert.assertEquals(2, node.occurrence(4));
        Assert.assertEquals(2, node.occurrence(5));
        Assert.assertEquals(1, node.occurrence(6));
        Assert.assertEquals(0, node.occurrence(7));
        Assert.assertEquals(0, Tree.occurrence(node, 2));
        Assert.assertEquals(1, Tree.occurrence(node, 3));
        Assert.assertEquals(2, Tree.occurrence(node, 4));
        Assert.assertEquals(2, Tree.occurrence(node, 5));
        Assert.assertEquals(1, Tree.occurrence(node, 6));
        Assert.assertEquals(0, Tree.occurrence(node, 7));
    }
}
