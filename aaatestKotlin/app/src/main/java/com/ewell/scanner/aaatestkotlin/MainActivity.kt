package com.ewell.scanner.aaatestkotlin

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.core.content.edit
import com.ewell.scanner.aaatestkotlin.application.CharacterGenerator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val CHARACTER_DATA_KEY = "CHARACTER_DATA_KEY"
    private val CHARACTER_DATA_API = "https://chargen-api.herokuapp.com/"

//    fun fetchCharacterData():CharacterGenerator.CharacterData{
//        val apiData = URL(CHARACTER_DATA_API).readText()
//        return CharacterGenerator.formApiData(apiData)
//    }

    //启用协程
    fun fetchCharacterData(): Deferred<CharacterGenerator.CharacterData> {
        return async {
            val apiData = URL(CHARACTER_DATA_API).readText()
            CharacterGenerator.formApiData(apiData)
        }

    }

    // **** 定义原有对象的属性
    private var Bundle.characterData
                get() = getSerializable(CHARACTER_DATA_KEY) as CharacterGenerator.CharacterData
                set(value) = putSerializable(CHARACTER_DATA_KEY , value)

    private var characterData = CharacterGenerator.generate()

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
//        outState.putSerializable(CHARACTER_DATA_KEY,characterData)
        outState.characterData = characterData
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //**** kotlin 可以直接使用id来寻找对应的view
        // import kotlinx.android.synthetic.main.activity_main.*
//        val nameTextview = findViewById<TextView>(R.id.nameTextView)
//        val raceTextview = findViewById<TextView>(R.id.raceTextView)
//        val dexterityTextview = findViewById<TextView>(R.id.dexterityTextView)
//        val wisdomTextview = findViewById<TextView>(R.id.wisdomTextView)
//        val strengthTextview = findViewById<TextView>(R.id.strengthTextView)
//        val generateButton = findViewById<Button>(R.id.generateButton)

//        characterData = savedInstanceState?.let { it.getSerializable(CHARACTER_DATA_KEY) as CharacterGenerator.CharacterData }
//            ?:CharacterGenerator.generate()
        characterData = savedInstanceState?.characterData ?:CharacterGenerator.generate()

        //**** 只有一个抽象方法的接口  可以直接写表达式
        generateButton.setOnClickListener {
//            characterData = CharacterGenerator.generate()  //随机获取数据
//            characterData = CharacterGenerator.formApiData("halfing,lars kizzy ,14,13,8")  // 字符串解析获取数据
//            characterData = fetchCharacterData()  // 网络获取数据 主线程调用网络会报错 NetworkOnMainThreadException
            //启用协程
            launch(UI) {
                characterData = fetchCharacterData().await()
                displayCharacterData()
            }
        }

        displayCharacterData()


    }

    private fun displayCharacterData(){
        //****  使用run标准函数
        characterData.run { nameTextView.text = name
            raceTextView.text = race
            dexterityTextView.text = dex
            wisdomTextView.text = wis
            strengthTextView.text = str}
    }

}
