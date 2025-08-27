package com.example.myapplication.util.system.lang

/**
 * Interface to handle crashes
 */
interface ExceptionListener {
	fun uncaughtException(thread: Thread, throwable: Throwable)
}
