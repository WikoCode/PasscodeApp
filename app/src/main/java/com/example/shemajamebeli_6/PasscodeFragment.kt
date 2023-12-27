package com.example.shemajamebeli_6

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.shemajamebeli_6.databinding.FragmentPasscodeBinding

class PasscodeFragment : BaseFragment<FragmentPasscodeBinding>(FragmentPasscodeBinding::inflate) {

    private val viewModel: PasscodeViewModel by viewModels()

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
        viewModel.addDigit(number)
        updateCircles()
        if (viewModel.enteredPasscode.length == 4) {
            checkPasscode()
        }
    }

    private fun handleDeleteClick() {
        viewModel.removeLastDigit()
        updateCircles()
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
                if (index < viewModel.enteredPasscode.length) R.drawable.ic_green_ellipse
                else R.drawable.ic_transparent_ellipse
            )
        }
    }


    private fun resetCircles() {
        updateCircles()
    }

    private fun checkPasscode() {
        if (viewModel.isPasscodeCorrect()) {
            Toast.makeText(requireContext(), "Success!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Incorrect Password", Toast.LENGTH_SHORT).show()
        }
        viewModel.resetPasscode()
        resetCircles()
    }


}
