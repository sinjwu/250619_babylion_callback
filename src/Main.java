public class Main {
    interface OnClickListener { //인터페이스를 만들고 구현체를 통해 실행
        void onClick();
    }
    private OnClickListener listener; //구현체를 사용해 실제로 저장할 필드

    public void setOnClickListener(OnClickListener listener) { //listener를 등록하는 setter
        this.listener = listener;
    }
    public void click() { //클릭했을 때 listener가 설정되어 있으면 동작
        if (listener != null) {
            listener.onClick();
        }
    }
    //내부 클래스: 외부와 강하게 결합되지 않음
    private class ClickHandler implements OnClickListener { //버튼 클릭 시 실제 수행할 로직
        //람다식으로 전환 가능
        public void onClick() {
            System.out.println("Button was clicked!");
        }
    }
    public void simulate() { //테스트
        setOnClickListener(new ClickHandler());
        //setOnClickListener(() -> System.out.println("Button was clicked!"));
        click();
    }
    public static void main(String[] args) {
        Main btn = new Main();
        btn.simulate();
    }
}