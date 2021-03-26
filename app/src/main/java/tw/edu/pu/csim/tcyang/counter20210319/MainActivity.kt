package tw.edu.pu.csim.tcyang.counter20210319

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {

    var counter:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txv.text = counter.toString()

        txv.setOnClickListener(this) //監控
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)//歸零
        btnHappy.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                counter= (1..100).random()
                txv.text = counter.toString()
            }
        })
        txv.setOnLongClickListener(this)//長按
        img.setOnLongClickListener(this)//長按圖片，還未做圖片設定

    }

    override fun onClick(v: View?) {
        if(v==txv || v==btn1){
            counter++
        }
        else if(v==btn2){
            counter+=2
        }
        else{
            counter=0
        }
        txv.text = counter.toString()
    }

    override fun onLongClick(v: View?): Boolean {
        if(v==txv) {
            counter += 2
            return true
        }
        else{
            counter += 3
            return true
        }
        txv.text = counter.toString()

    }

}