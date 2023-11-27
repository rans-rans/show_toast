package com.flutlin.show_toast

import android.widget.Toast
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {


    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        val methodChannel =
            MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "method_channel")

        methodChannel.setMethodCallHandler { call, results ->

            when (call.method) {
                "show_toast" -> {
                    val msg = call.arguments as String
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                    results.success("The message is from kotlin is $msg")
                }

            }


        }
    }
}
