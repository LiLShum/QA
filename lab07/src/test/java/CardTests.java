import org.example.BankAccount;
import org.example.Card;
import org.testng.Assert;
import org.testng.annotations.*;

public class CardTests {
    Card card;
    @BeforeSuite
    public void startTest(){
        System.out.println("Test started");
    }
    @BeforeTest
    public void startClassTest(){
        System.out.println("Test class Card start");
    }

    @BeforeClass
    public void beforeTest() {
        card = new Card("Nikita",0,"null");
        System.out.println("Class created");
    }

    @Test(dataProvider = "testDepositMoney")
    public void testDepositMoney(float sum, float resultSum){
        this.card.balance = 0;
        this.card.depositMoney(sum);
        Assert.assertEquals(this.card.balance,resultSum);
    }

    @Test(groups = "depositMoneyAndUnblock")
    public void testBalance(){
        this.card.depositMoney(1000);
        Assert.assertEquals(this.card.balance,2000);
    }
    @BeforeMethod
    public void mnogoDeneg(){
        this.card.balance = 1000;
    }
    @Test(groups = "depositMoneyAndUnblock")
    public void testUnblpcked(){
        this.card.unblock();
    }

    @Test(dependsOnGroups = "depositMoneyAndUnblock", dataProvider = "testStatusAndDepositMoney", timeOut = 100)
    public void testPay(float sum, String status ,float paySum,float result){
        this.card.balance = 0;
        this.card.status = status;
        this.card.depositMoney(paySum);
        this.card.pay(sum);
        Assert.assertEquals(this.card.balance,result);
    }

    @DataProvider(name = "testDepositMoney")
    public Object[][] createData1() {
        return new Object[][] {
                {1000,1000},
                {2000,2000},
                {12,12},
        };
    }
    @DataProvider(name = "testStatusAndDepositMoney")
    public Object[][] createData2() {
        return new Object[][] {
                {10000,"unblocked",1000,1000},
                {777,"blocked",1000,1000},
                {777,"unblocked",1000,223},
        };
    }

   @Test
    public void TestCardAndBank(){
        float result = card.balance;
        BankAccount bankAccount = new BankAccount("Nikita");
        bankAccount.addCard(card);
        Assert.assertEquals(bankAccount.getAllBalance(),card.getBalance());
    }

    @Ignore
    @Test
    public void testIgnore(){
        System.out.println("Test ignored");
    }

    @Test
    public void blockedCardTest(){
        this.card.block();
        Assert.assertEquals(this.card.status,"blocked");
    }
    @Test(dependsOnMethods = "blockedCardTest")
    public void unblockedTest(){
        this.card.unblock();
        Assert.assertEquals(this.card.status,"unblocked");
    }


    @AfterClass
    public void endClass(){
        System.out.println("Class Card test successfully");
    }
    @AfterSuite
    public void endTestSuite(){
        System.out.println("Test suite successfully");
    }
    @AfterTest
    public void endTest(){
        System.out.println("Test successfully");
    }
}
