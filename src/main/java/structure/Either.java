package structure;

import java.util.Objects;

/**
 * 스칼라의 Either 클래스를 흉내낸다.<br/>
 * 분리합집합(disjoint union)이라고도 불리며, 왼쪽 또는 오른쪽 중 한 곳에만 값이 존재한다.<br/>
 * 이러한 Either는 주로 예외처리에 사용된다고 한다.<br/>
 * 예외가 발생한 경우에는 왼쪽에 예외 메시지가 담기고,<br/>
 * 정상 결과를 구한 경우 오른쪽에 값이 담긴다
 */
public class Either<Left, Right> {

    private Left left;
    private Right right;

    private Either(Left left, Right right) {
        this.left = left;
        this.right = right;
    }

    public static <Left, Right> Either<Left, Right> left(Left left) {
        return new Either<Left, Right>(left, null);
    }

    public static <Left, Right> Either<Left, Right> right(Right right) {
        return new Either<Left, Right>(null, right);
    }

    public Left left() {
        return left;
    }

    public Right right() {
        return right;
    }

    public boolean hasLeft() {
        return Objects.nonNull(left);
    }

    public boolean hasRight() {
        return Objects.nonNull(right);
    }
}
