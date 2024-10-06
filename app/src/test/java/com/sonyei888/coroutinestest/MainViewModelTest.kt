package com.sonyei888.coroutinestest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock

class MainViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get: Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private lateinit var vm: MainViewModel

    @Before
    fun setUp() {
        vm = MainViewModel(coroutinesTestRule.testDispatcher)
    }

    @Test
    fun `success if user and pass are not empty`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val observer = mock<Observer<Boolean>>()
        vm.loginResult.observeForever(observer)

        vm.onSubmitClicked("user", "pass")

        verify(observer).onChanged(true)
    }

    @Test
    fun `erro if user is empty`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val observer = mock<Observer<Boolean>>()
        vm.loginResult.observeForever(observer)

        vm.onSubmitClicked("", "pass")

        verify(observer).onChanged(false)
    }
}