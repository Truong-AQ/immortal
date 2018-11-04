/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import static bom.ScreenPlay.sizeIcon;
import static bom.ScreenPlay.sizeTimeAndScore;
import java.awt.Point;
import static java.lang.Math.abs;
import static java.lang.Math.random;
import java.util.Vector;
import javax.swing.ImageIcon;

/**
 *
 * @author Genius
 */
public abstract class MotionCharacter extends Character{
    protected int x, y;
    protected char status = 'r', previousStatus = 'r';
}
abstract class Monster extends MotionCharacter{
    protected char[] allStatus = {'l', 'r', 'u', 'd'};
    protected int nStatus = allStatus.length, step = sizeIcon/4;
    public abstract void settingsNewIcon();
    public void move(){
        caculateStatus();
        settingsNewIcon();
    }
    public void caculateStatus(){
        int tx, ty;
        char c = status;
        if(testAllStatus(x, y))//kiem tra xem quai vat co the nhuc nhich duoc khong
        while(true){
            switch (c) {
                case 'l':
                    tx = x - step;
                    ty = y - sizeTimeAndScore;
                    break;
                case 'r':
                    tx = x + step;
                    ty = y - sizeTimeAndScore;
                    break;
                case 'u':
                    tx = x;
                    ty = y - step - sizeTimeAndScore;
                    break;
                default:
                    tx = x;
                    ty = y + step - sizeTimeAndScore;
                    break;
            }
            if(monsterCanMove(tx, ty, c)){
                x = tx;
                y = ty + sizeTimeAndScore;
                previousStatus = status;
                status = c;

                this.setBounds(x, y, sizeIcon, sizeIcon);
                return;
            }
            c = allStatus[(int)(random()*nStatus)];
        }
    }
    private boolean testAllStatus(int tx, int ty){
       if(tx%sizeIcon != 0
               || (ty%sizeIcon != 0))
           return true;
       int i = ty/sizeIcon, j = tx/sizeIcon;
       if(!(ScreenPlay.allCharacter[i - 1][j] instanceof Grass)
               && !(ScreenPlay.allCharacter[i + 1][j] instanceof Grass)
               && !(ScreenPlay.allCharacter[i][j - 1] instanceof Grass)
               && !(ScreenPlay.allCharacter[i - 1][j + 1] instanceof Grass))
        return false;
       return true;
    }
    //cac monster di chuyen neu vi tri chinh xac, khac bomber
    public boolean monsterCanMove(int tx, int ty, char tStatus){
        int i = 0, j = 0;
        boolean ok = false;
        //tinh vi tri vat ma monster se di vao tiep theo
        if(tx%sizeIcon == 0
                && ty%sizeIcon == 0){
            i = ty/sizeIcon;
            j = tx/sizeIcon;
            ok = true;
        }
        else if(tx%sizeIcon == 0
                && (tStatus == 'u'
                || tStatus == 'd')){
            j = tx/sizeIcon;
            if(tStatus == 'u'){
                i = ty/sizeIcon;
            }
            else{
                i = ty/sizeIcon + 1;
            }
            ok = true;
        }
        else if(ty%sizeIcon == 0
                &&(tStatus == 'l'
                || tStatus == 'r')){
            i = ty/sizeIcon;
            if(tStatus == 'l')
                j = tx/sizeIcon;
            else
                j = tx/sizeIcon + 1;
            ok = true;
        }
        //xu li va cham
        if(ok == true)
        if(ScreenPlay.allCharacter[i][j] instanceof Grass){
            return ok;
        }
        else
            ok = false;
        return ok;
    }
}
class Bomber extends MotionCharacter{
    private final int step = sizeIcon/4, nStepLimitGo = 2, nStepLimPutBom = 1;
    public static Vector <Bomb> boms = new Vector();
    //thiet lap tat ca hinh anh hoat hinh cua bomber
    private final ImageIcon[] Up = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_up.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_up_1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_up_2.png"))
    };
    private final ImageIcon[] Down = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_down.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_down_1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_down_2.png"))
    };
    private final ImageIcon[] Left = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_left.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_left_1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_left_2.png"))
    };
    private final ImageIcon[] Right = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_right.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_right_1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_right_2.png"))
    };
    private final int lengthUp = Up.length, lengthDown = Down.length, lengthLeft = Left.length, lengthRight = Right.length;
    private int numericalOrder = 0;//hinh thu numerical order trong cac mang Up, Down,...
    public Bomber(int i, int j) {
        ii = Right[0];
        this.setIcon(ii);
        x = j*sizeIcon;
        y = sizeTimeAndScore + i*sizeIcon;
        this.setBounds(x, y, sizeIcon, sizeIcon);
    }

    public void move(char input) {
        if(bomberCanMove(input)){
            //thiet lap icon moi;
            if(previousStatus == status){
                switch (status) {
                    case 'l':
                        numericalOrder = (numericalOrder + 1)%lengthLeft;
                        break;
                    case 'r':
                        numericalOrder = (numericalOrder + 1)%lengthRight;
                        break;
                    case 'u':
                        numericalOrder = (numericalOrder + 1)%lengthUp;
                        break;
                    default:
                        numericalOrder = (numericalOrder + 1)%lengthDown;
                        break;
                }
            }
            else
                numericalOrder = 0;
            switch (status) {
                    case 'l':
                        ii = Left[numericalOrder];
                        break;
                    case 'r':
                        ii = Right[numericalOrder];
                        break;
                    case 'u':
                        ii = Up[numericalOrder];
                        break;
                    default:
                        ii = Down[numericalOrder];
                        break;
                }
            this.setIcon(ii);
            //thiet lap vi tri moi
            this.setBounds(x, y, sizeIcon, sizeIcon);
        }
    }
    public void putBoms(){
        int i = (y - sizeTimeAndScore)/sizeIcon, j = x/sizeIcon;
        if((y - sizeTimeAndScore - i*sizeIcon) > nStepLimPutBom*step)
            i ++;
        if((x - j*sizeIcon) > nStepLimPutBom*step)
            j ++;
        boms.add(new Bomb(i, j));
        ScreenPlay.allCharacter[i][j].setVisible(false);
        ScreenPlay.pane.add(boms.elementAt(boms.size() - 1));
    }
    private boolean bomberCanMove(char input) {
        int tx = x, ty = y - sizeTimeAndScore;//dung de tinh toan toa do tiep theo bomber den neu den duoc
        switch (input) {
            case 'w':
                ty -= step;
                previousStatus = status;
                status = 'u';
                break;
            case 's':
                ty +=step;
                previousStatus = status;
                status = 'd';
                break;
            case 'a':
                tx -=step;
                previousStatus = status;
                status = 'l';
                break;
            default:
                tx +=step;
                previousStatus = status;
                status = 'r';
                break;
        }
        //dung tinh toan vi tri o co toa do tx, ty theo trong map
        Point[] p = new Point[2];//bomber co the den duoc toi da 1 trong 2 o
        int count = 1;
        switch (status) {
            case 'l':
                p[0] = new Point(ty/sizeIcon, tx/sizeIcon);
                if(ty%sizeIcon != 0){
                    p[1] = new Point(ty/sizeIcon + 1, tx/sizeIcon);//bomber co the den o thu hai khi toa do bomber khong vua kich thuoc o 
                    count ++;
                }
                break;
            case 'r':
                int j = tx/sizeIcon + 1;
                if(tx%sizeIcon == 0)
                    j --;
                p[0] = new Point(ty/sizeIcon, j);
                if(ty%sizeIcon != 0){
                    p[1] = new Point(ty/sizeIcon + 1, j);
                    count ++;
                }
                break;
            case 'u':
                p[0] = new Point(ty/sizeIcon, tx/sizeIcon);
                if(tx%sizeIcon != 0){
                    p[1] = new Point(ty/sizeIcon, tx/sizeIcon + 1);
                    count ++;
                }
                break;
            default:
                int i = ty/sizeIcon + 1;
                if(ty%sizeIcon == 0)
                    i --;
                p[0] = new Point(i, tx/sizeIcon);
                if(tx%sizeIcon != 0){
                    p[1] = new Point(i, tx/sizeIcon + 1);
                    count ++;
                }
                break;
        }
        //xu li xem co den duoc o do khong
        for(int i = 0;i < count;i ++){
            Character ch = ScreenPlay.allCharacter[(int)p[i].getX()][(int)p[i].getY()];
            if(ch instanceof Grass
                    && !conditionCollision((int)p[i].getX(), (int)p[i].getY())){
                //xu li de bomber co dieu kien di ngoat (khi bomber chua den vi tri chinh xac cua o da co the di tiep)
                if(status == 'l'
                        || status == 'r'){
                    int yOld = y, yNew = (int)p[i].getX()*sizeIcon + sizeTimeAndScore;
                    if(abs(yOld - yNew) > nStepLimitGo*step)
                        continue;
                }
                else{
                    int xOld = x, xNew = x = (int)p[i].getY()*sizeIcon;
                    if(abs(xOld - xNew) > nStepLimitGo*step)
                        continue;
                }
                //dieu kien bomber di tiep la thoa man, dat toa do moi cho bomber (chuan hoa toa do)
                if(status == 'l'
                        || status == 'r'){
                    x = tx;
                    y = (int)p[i].getX()*sizeIcon + sizeTimeAndScore;
                }
                else{
                    x = (int)p[i].getY()*sizeIcon;
                    y = ty + sizeTimeAndScore;
                }
                return true;
            }
        }
        return false;
    }
    public boolean conditionCollision(int i, int j){
        for(int k = 0;k < boms.size();k ++)
            if(boms.elementAt(k).getI() == i
                    && boms.elementAt(k).getJ() == j
                    && !((x == i*sizeIcon) && (y == j*sizeIcon)))//dieu kien khong o trong bom
        return true;
        return false;
    }
}
class Ballon extends Monster{
    //thiet lap tat ca hoat hinh cua Ballon
    ImageIcon[] Left = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/balloom_left1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/balloom_left2.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/balloom_left3.png"))
    };
    ImageIcon[] Right = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/balloom_right1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/balloom_right2.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/balloom_right3.png"))
    };
    ImageIcon[] UD = {
        Left[0],
        Left[1],
        Left[2],
        Right[0],
        Right[1],
        Right[2],
    };
    private final int lengthLeft = Left.length, lengthRight = Right.length, lengthUD = UD.length;
    public Ballon(int i, int j) {
        ii = Right[0];
        this.setIcon(ii);
        x = j*sizeIcon;
        y = sizeTimeAndScore + i*sizeIcon;
        this.setBounds(x, y, sizeIcon, sizeIcon);
    }
    private int numericalOrder = 0;
    @Override
    public void settingsNewIcon() {
        //hien thi hinh anh sao cho di chuyen len xuong ballon van quay mat trai phai
        if(previousStatus == status
                || previousStatus*status == 'u'*'d'){
            switch (status) {
                case 'l':
                    numericalOrder = (numericalOrder + 1)%lengthLeft;
                    break;
                case 'r':
                    numericalOrder = (numericalOrder + 1)%lengthRight;
                    break;
                default:
                    numericalOrder = (numericalOrder + 1)%lengthUD;
                    break;
            }
        }
        else
            numericalOrder = 0;
        switch (status) {
            case 'l':
                ii = Left[numericalOrder];
                break;
            case 'r':
                ii = Right[numericalOrder];
                break;
            default:
                ii = UD[numericalOrder];
                break;
        }
        this.setIcon(ii);
    }
}
class Oneal extends Monster{
    //thiet lap tat ca hoat hinh cua Oneal
    ImageIcon[] Left = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/oneal_left1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/oneal_left2.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/oneal_left3.png"))
    };
    ImageIcon[] Right = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/oneal_right1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/oneal_right2.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/oneal_right3.png"))
    };
    ImageIcon[] UD = {
        Left[0],
        Left[1],
        Left[2],
        Right[0],
        Right[1],
        Right[2]
    };
    private final int lengthLeft = Left.length, lengthRight = Right.length, lengthUD = UD.length;
    private int numericalOrder = 0;
    public Oneal(int i, int j) {
        ii = Right[0];
        this.setIcon(ii);
        x = j*sizeIcon;
        y = sizeTimeAndScore + i*sizeIcon;
        this.setBounds(x, y, sizeIcon, sizeIcon);
    }
    
    @Override
    public void settingsNewIcon() {
        //hien thi hinh anh sao cho di chuyen len xuong ballon van quay mat trai phai
        if(previousStatus == status
                || previousStatus*status == 'u'*'d'){
            switch (status) {
                case 'l':
                    numericalOrder = (numericalOrder + 1)%lengthLeft;
                    break;
                case 'r':
                    numericalOrder = (numericalOrder + 1)%lengthRight;
                    break;
                default:
                    numericalOrder = (numericalOrder + 1)%lengthUD;
                    break;
            }
        }
        else
            numericalOrder = 0;
        switch (status) {
            case 'l':
                ii = Left[numericalOrder];
                break;
            case 'r':
                ii = Right[numericalOrder];
                break;
            default:
                ii = UD[numericalOrder];
                break;
        }
        this.setIcon(ii);
    }
}
