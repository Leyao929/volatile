package cn.leyao.volatiles;


class Calc{

    volatile int num = 0;

    public void setNum(int num){
        this.num = num;

    }

    public int getNum(){


        return num;
    }

    public void addTo60(){

        num = 60;

    }

}

public class VolatileTest {


    public static void main(String[] args) throws InterruptedException {

        Calc cal = new Calc();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName() + "线程进来了" );

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                /*cal.addTo60();*/

                cal.setNum(60);

                System.out.println(Thread.currentThread().getName() + "\t修改了数据，值为" + cal.getNum());

            }
        },"A");


        t.start();

        /*Thread.sleep(10000);*/

        while (cal.getNum() == 0){

        }

        System.out.println(Thread.currentThread().getName() +"\t获取的值为:" + cal.getNum());
    }

}
