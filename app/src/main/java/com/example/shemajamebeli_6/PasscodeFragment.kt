package com.example.shemajamebeli_6

import android.widget.Toast
import com.example.shemajamebeli_6.databinding.FragmentPasscodeBinding

class PasscodeFragment : BaseFragment<FragmentPasscodeBinding>(FragmentPasscodeBinding::inflate) {

    private val correctPasscode = "0934"
    private var enteredPasscode = ""

    override fun setupUI() {
        resetCircles()
    }

    override fun setupListeners() {
        buttonListeners()
    }


    private fun buttonListeners() {
        binding.apply {
            btnZero.setOnClickListener { handleButtonClick("0") }
            btnOne.setOnClickListener { handleButtonClick("1") }
            btnTwo.setOnClickListener { handleButtonClick("2") }
            btnThree.setOnClickListener { handleButtonClick("3") }
            btnFour.setOnClickListener { handleButtonClick("4") }
            btnFive.setOnClickListener { handleButtonClick("5") }
            btnSix.setOnClickListener { handleButtonClick("6") }
            btnSeven.setOnClickListener { handleButtonClick("7") }
            btnEight.setOnClickListener { handleButtonClick("8") }
            btnNine.setOnClickListener { handleButtonClick("9") }
            btnDelete.setOnClickListener { handleDeleteClick() }

        }

    }

    private fun handleButtonClick(number: String) {
        if (enteredPasscode.length < 4) {
            enteredPasscode += number
            updateCircles()
        }
        if (enteredPasscode.length == 4) {
            checkPasscode()
        }
    }

    private fun handleDeleteClick() {
        if (enteredPasscode.isNotEmpty()) {
            enteredPasscode = enteredPasscode.dropLast(1)
            updateCircles()
        }
    }


    private fun updateCircles() {
        val circles = listOf(
            binding.ivPasscodeOne,
            binding.ivPasscodeTwo,
            binding.ivPasscodeThree,
            binding.ivPasscodeFour
        )
        circles.forEachIndexed { index, imageView ->
            imageView.setImageResource(
                if (index < enteredPasscode.length) R.drawable.ic_green_ellipse
                else R.drawable.ic_transparent_ellipse
            )
        }
    }


    private fun resetCircles() {
        enteredPasscode = ""
        updateCircles()
    }

    private fun checkPasscode() {
        if (enteredPasscode == correctPasscode) {
            Toast.makeText(requireContext(), "Success!", Toast.LENGTH_SHORT).show()
            resetCircles()
        } else {
            Toast.makeText(requireContext(), "Incorrect Password", Toast.LENGTH_SHORT).show()
            resetCircles()
        }
    }

}
