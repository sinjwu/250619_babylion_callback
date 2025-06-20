public class Main2 {
    private String data = "Outer data";

    class Inner {
        void printData() {
            System.out.println(data);
        }
    }
    public Inner createInner() {     // 반환타입이 Inner 여서
        return new Inner();          // return 값으로 new Inner(); 가능
    }                                // 즉, 메소드 호출로 Inner 클래스 인스턴스를 만드는 메소드
    public static void main(String[] args) {
        Main2 outer = new Main2();

        Main2.Inner inner = outer.createInner(); // Inner 클래스 인스턴스를 만드는 메소드
        // outer.new Inner(); 로 대체 가능
        inner.printData();
        outer = null;                           // outer 메모리를 날려도
        inner.printData();                      // 실행 됨
        inner = null;                           // inner 메모리 날리면
//      inner.printData();                      // 실행 안됨
        System.gc();                            // 가비지 컬렉터 호출 요청
        System.out.println("Outer와 Inner는 더 이상 사용되지 않음");
    }
}