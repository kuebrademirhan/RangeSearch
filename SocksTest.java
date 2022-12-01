





public class SocksTest {

    @Test
    public void Sock(){
        Sock temp=new Sock(0,null);

        Assert.assertEquals("s should be 0", 0.0,temp.s);
        Assert.assertEquals("If d is null it should return empty string","",temp.d);
        Assert.assertEquals("wrong result","s=" + 0.0 + ",d=[uni]",temp.toString());
        Sock temp1=new Sock(-1,"a");
        Assert.assertEquals("s should be 0",0.0,temp1.s);
        Assert.assertEquals("wrong d","a",temp1.d);
        Assert.assertEquals("wrong result","s=" + 0.0 + ",d=" + "a",temp1.toString());
        Sock temp2=new Sock(2,"");
        Assert.assertEquals("wrong result","s=" + 2.0 + ",d=[uni]",temp2.toString());
    }


    @Test

    public void SockDesignComparator(){
        SocksDesignComparator temp=new SocksDesignComparator();
        Sock o1=new Sock(1,"");
        Sock o2=new Sock(2,"a");
        Assert.assertEquals("result is wrong",-1,temp.compare(o1,o2));
        Sock tempo1=new Sock(1,"a");
        Sock tempo2=new Sock(2,"");
        Assert.assertEquals("result is wrong",1,temp.compare(tempo1,tempo2));
        Sock tempo11=new Sock(1,"ab");
        Sock tempo22=new Sock(2,"a");
        Assert.assertEquals("result is wrong",1,temp.compare(tempo11,tempo22));



    }
    @Test

    public void SocksDoubleComparator(){
        SocksSizeComparator ssc1=new SocksSizeComparator();
        SocksDesignComparator sdc1 =new SocksDesignComparator();
        SocksDoubleComparator temp=new SocksDoubleComparator(ssc1,sdc1);
        Sock s1=new Sock(1,"");
        Sock s2=new Sock(2,"a");
        Assert.assertEquals("result is wrong",-1,temp.compare(s1,s2));
        Sock s11=new Sock(2,"");
        Sock s21=new Sock(1,"a");
        Assert.assertEquals("result is wrong",1,temp.compare(s11,s21));
        Sock s112=new Sock(1,"");
        Sock s212=new Sock(1,"a");
        Assert.assertEquals("result is wrong",-1,temp.compare(s112,s212));
        Sock s122=new Sock(1,"a");
        Sock s222=new Sock(1,"");
        Assert.assertEquals("result is wrong",1,temp.compare(s122,s222));
        Sock s12=new Sock(1,"a");
        Sock s22=new Sock(1,"a");
        Assert.assertEquals("result is wrong",0,temp.compare(s12,s22));
        Sock s123=new Sock(1,"ab");
        Sock s223=new Sock(1,"a");
        Assert.assertEquals("result is wrong",1,temp.compare(s123,s223));


    }

    @Test
    public void SocksSizeComparator(){
        SocksSizeComparator temp=new SocksSizeComparator();
        Sock s1=new Sock(1,"");
        Sock s2=new Sock(2,"");
        Assert.assertEquals("result is wrong",-1,temp.compare(s1,s2));
        Sock s11=new Sock(2,"");
        Sock s21=new Sock(1,"");
        Assert.assertEquals("result is wrong",1,temp.compare(s11,s21));
        Sock s111=new Sock(2,"");
        Sock s211=new Sock(2,"");
        Assert.assertEquals("result is wrong",0,temp.compare(s111,s211));


    }
    @Test
    public void SocksSorter(){
        Sock s1=new Sock(4,"a");
        Sock s2=new Sock(2,"b");
        Sock[] arr=new Sock[]{s1,s2};
        SocksSizeComparator temp1=new SocksSizeComparator();
        SocksSorter<Sock> temp=new SocksSorter(arr,temp1);
        Assert.assertEquals("Comparison wrong",true,temp.sort(0,1));
        Sock s11=new Sock(1,"a");
        Sock s22=new Sock(2,"b");
        arr=new Sock[]{s11,s22};
        SocksSorter<Sock> tempp=new SocksSorter(arr,temp1);
        Assert.assertEquals("Comparison wrong",true,tempp.sort(0,1));
        SocksSorter<Sock> temp11=new SocksSorter(null,temp1);
        Assert.assertEquals("Comparison wrong",false,temp11.sort(0,1));





    }

}
