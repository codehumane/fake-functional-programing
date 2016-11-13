package structure;

import java.util.function.Function;

public class Tree {

    /**
     * Either를 활용한 노드의 깊이 구하기
     * @param node
     * @return
     */
    public static final int depth(Node node) {
        return processEither(
                node.toEither(),
                empty -> 0,
                leaf -> 1,
                x -> Math.max(depth(x.left), depth(x.right)) + 1
        );
    }

    /**
     * Either를 활용한 자신 혹은 자식 노드내 값 존재여부 확인
     * @param node
     * @param value
     * @return
     */
    public static final boolean contains(Node node, int value) {
        return processEither(
                node.toEither(),
                x -> false,
                x -> x.value == value,
                x -> contains(x.left, value) || contains(x.right, value)
        );
    }

    /**
     * Either를 활용한 자신 또는 자식 노드내 값이 몇개나 존재하는지 여부 확인
     * @param value
     * @return
     */
    public static final int occurrence(Node node, int value) {
        return processEither(
                node.toEither(),
                x -> 0,
                x -> (x.value == value) ? 1 : 0,
                x -> occurrence(x.left, value) + occurrence(x.right, value)
        );
    }

    /**
     * Either<Empty, Either<LeafNode, InternalNode>>의 공통된 처리 흐름을 담당한다.
     * @param either
     * @param onEmpty either가 {@link Empty} 값을 가지는 경우의 처리
     * @param onLeaf either가 {@link LeafNode} 값을 가지는 경우의 처리
     * @param onInternal either가 {@link InternalNode} 의 값을 가지는 경우의 처리
     * @param <T> 각 함수의 공통 반환 값
     * @return
     */
    private static final <T> T processEither(
            Either<Empty, Either<LeafNode, InternalNode>> either,
            Function<Empty, T> onEmpty, Function<LeafNode, T> onLeaf,
            Function<InternalNode, T> onInternal) {

        if (either.hasLeft()) {

            // empty
            return onEmpty.apply(either.left());
        } else {

            Either<LeafNode, InternalNode> right = either.right();
            if (right.hasLeft()) {

                // leaf
                return onLeaf.apply(right.left());
            } else {

                // internal
                return onInternal.apply(right.right());
            }
        }
    }

    interface Node {

        /**
         * Either 변환
         * @return
         */
        Either<Empty, Either<LeafNode, InternalNode>> toEither();

        /**
         * 깊이 반환
         * @return
         */
        int depth();

        /**
         * 자신 또는 자식 노드내 값 존재 여부 확인
         * @return
         */
        boolean contains(int value);

        /**
         * 자신 또는 자식 노드내 값이 몇개나 존재하는지 여부 확인
         * @return
         */
        int occurrence(int value);
    }

    /**
     * 비어있음을 나타냄
     */
    public static final class Empty implements Node {

        @Override
        public Either<Empty, Either<LeafNode, InternalNode>> toEither() {
            return Either.left(this);
        }

        @Override
        public int depth() {
            return 0;
        }

        @Override
        public boolean contains(int value) {
            return false;
        }

        @Override
        public int occurrence(int value) {
            return 0;
        }
    }

    /**
     * 자식이 없는 노드
     */
    public static final class LeafNode implements Node {

        private final int value;

        public LeafNode(int value) {
            this.value = value;
        }

        @Override
        public Either<Empty, Either<LeafNode, InternalNode>> toEither() {
            return Either.right(Either.<LeafNode, InternalNode>left(this));
        }

        @Override
        public int depth() {
            return 1;
        }

        @Override
        public boolean contains(int value) {
            return this.value == value;
        }

        @Override
        public int occurrence(int value) {
            return contains(value) ? 1 : 0;
        }
    }

    /**
     * 자식이 있는 노드
     */
    public static final class InternalNode implements Node {

        private final Node left;
        private final Node right;

        public InternalNode(Node left, Node right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public Either<Empty, Either<LeafNode, InternalNode>> toEither() {
            return Either.right(Either.<LeafNode, InternalNode>right(this));
        }

        @Override
        public int depth() {
            return Math.max(left.depth(), right.depth()) + 1;
        }

        @Override
        public boolean contains(int value) {
            return left.contains(value) || right.contains(value);
        }

        @Override
        public int occurrence(int value) {
            return left.occurrence(value) + right.occurrence(value);
        }
    }
}
