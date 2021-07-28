package sample;

import java.io.IOException;

public class clientThread implements Runnable{
    Thread t;
    private Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    volatile   private Object obj;
    volatile private Object finalobj;
    NetworkUtil networkUtil;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        System.out.println("yayyyy");
        this.obj = obj;
    }

    public Object getFinalobj() {
        return finalobj;
    }

    public void setFinalobj(Object finalobj) {
        this.finalobj = finalobj;
    }

    clientThread(NetworkUtil networkUtil,Main main)
    {
        this.main=main;
        obj=null;
        finalobj=null;
        this.networkUtil=networkUtil;
        t=new Thread(this,"clientthread");
        System.out.println("welcome to client thread");
                t.start();


    }
    @Override
    public void run() {
        try {
            while (true) {
               // System.out.println("reading and checking");
                Object obj1=getObj();

                if (obj1 != null)
                {
                    System.out.println("client thread entered");
                    if (obj1 instanceof Sell)
                    {
                        Sell sell=(Sell)obj1;
                        networkUtil.write(sell);
                        System.out.println("done");
                        obj=null;
                    }
                    if(obj1 instanceof Buy)
                    {
                        Buy buy=(Buy)obj1;
                        if(buy.getState()==0)
                        {
                            System.out.println("trying to write from client thread now");
                            networkUtil.write(buy);
                            System.out.println("writing done ..now waiting for reading..");
                           Object obj2= networkUtil.read();
                            System.out.println("reading doneee");
                           setFinalobj(obj2);
                            System.out.println("all done");
                           obj=null;
                        }
                        if(buy.getState()==2)
                        {
                            System.out.println("state 2");
                            System.out.println("trying to write from client thread now");
                            networkUtil.write(buy);
                            System.out.println("writing done ..now waiting for reading..");
                            Object obj2= networkUtil.read();
                            System.out.println("reading doneee");
                            setFinalobj(obj2);
                            System.out.println("all done");
                            obj=null;
                        }
                    }

                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
