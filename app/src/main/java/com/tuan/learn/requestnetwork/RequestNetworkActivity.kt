package com.tuan.learn.requestnetwork

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tuan.learn.databinding.ActivityRequestNetworkBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.observers.DisposableObserver as DisposableObserver1

class RequestNetworkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRequestNetworkBinding

    private lateinit var tvHello: TextView
    private lateinit var tvResultCombine: TextView
    private lateinit var edtInput1: EditText
    private lateinit var edtInput2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestNetworkBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tvHello = binding.tvHello
        tvResultCombine = binding.tvResultCombine
        edtInput1 = binding.edtInput1
        edtInput2 = binding.edtInput2

//        test1()

        test2()
    }

    private fun test2() {
        RxTextVi
    }

    fun test1() {

        getAllPerson()
            .subscribeOn(Schedulers.io())
            .filter { person -> person.age > 12 }
            .doOnNext {
                Log.d("TTT", "String: $it current thread: " + Thread.currentThread().name)
            }
            .doOnComplete {
                Log.d("TTT", "OK Complete: current thread: " + Thread.currentThread().name)
            }
//            .observeOn(AndroidSchedulers.mainThread())
            .doFinally {
                Log.d("TTT", "doFinally1 called: current thread: " + Thread.currentThread().name)
            }
//            .observeOn(Schedulers.newThread())
            .doFinally {
                Log.d("TTT", "doFinally2 called: current thread: " + Thread.currentThread().name)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver1<Person>() {
                override fun onNext(t: Person?) {

                }

                override fun onError(e: Throwable?) {
                    TODO("Not yet implemented")
                }

                override fun onComplete() {
                    TODO("Not yet implemented")
                }

            })


    }

    fun retrieveData(): Observable<String> {
        val stringData = "Le Quoc Tuan hahaha hi hehe"
//        return Observable.just(stringData)
        return Observable.just("Hell", "Kaka", "Kiki")
    }

    fun getAllPersonYoung(): Observable<Person> {
        val listPerson = mutableListOf<Person>()
        for (i in 0..10) {
            val person = Person("PersonYoung-$i", i + 10)
            listPerson.add(person)
        }

        return Observable.fromIterable(listPerson)
    }

    fun getAllPerson(): Observable<Person> {
        val listPerson = mutableListOf<Person>()
        for (i in 0..10) {
            val person = Person("Person-$i", i + 10)
            listPerson.add(person)
        }

        return Observable.fromIterable(listPerson)
    }

    data class Person(val name: String, val age: Int)


    fun processData(data: String) {
        tvHello.text = data
    }

}