#################################################################
#ReadMe 
#File: p1_15116158.s                                              #
#                                                               #
# This program is to print out the number in
# Binary , Octal, Hexadecimal format
# The design of this program is that use different bit to present 
# the value of different number system.
# such as use 1 bit in Binary, 3bit in Octal, 4 bit in Hexadecimal 
# 
# You need to know:
# you should input one decimal number start by 0 up to 2^32-1
# it should be a number                                                       #
#################################################################

####################
# The data segment #
####################

                 .data

# Create some null terminated strings which are to be used in the program

strPromptFirst:  .asciiz "Enter a number:"
strPromptSecond: .asciiz "\nInput number is "
strPromptThrid:  .asciiz "\nBinary code is "
strPromptFour:  .asciiz "\nOctal code is "
strPromptFive:  .asciiz "\nHexadecimal code is "
strPromptSix:  .asciiz "\nContinue? (Y/N) "
strPromptBye:  .asciiz "\nBye! "
strNo:			.asciiz "N"
strYes:			.asciiz "Y"
strSpace:  .asciiz " "
var1:   .word   101
buffer: .space 10
letter: .space 1

###############################################
# The text segment -- instructions start here #
###############################################

    .text
    .globl main

main:
    # STEP 1 -- get the first number
    # Print a prompt asking user for input

    li $v0, 4                  # syscall number 4 prints string whose address is in $a0
    la $a0, strPromptFirst     # "load address" of the string
    syscall                    # actually print the string

    # Now read in the first number

    li $v0, 5                  # syscall number 5 reads an int
    syscall                    # actually read the int
    move $t0, $v0              # save input in $t0
    move $t1, $t0
    # STEP 2 -- repeat above steps to get the second number
    # First print the prompt

    li $v0, 4                  # syscall number 4 prints string whose address is in $a0
    la $a0, strPromptSecond                
    syscall                    # actually print the string
    li $v0,1
    move $a0,$t0
    syscall

    sb $t1,var1
###########
#Binarycode
    li $v0, 4                  # syscall number 4 prints string whose address is in $a0
    la $a0, strPromptThrid                
    syscall                    # actually print the string
    li $t2,0x80000000		#give a mask in the first bit is 1
    li $t3,0  				#counter
    and $s1,$t1,$t2			#and opeartor to get the value of the bit
    beq $s1,0,noBin			
loopBit:					#make the number shift to the right side
	srl $s1,$s1,1
    bne $s1,1,loopBit

noBin:
    move $a0,$s1
    li $v0,1  
    syscall
    add $t3,$t3,1

loopBinary:
    srl $t2,$t2,1
    and $s1,$t1,$t2
    bne $s1,0,checkisBin

endCheckTwo:
    move $a0,$s1
    li $v0,1  
    syscall
    add $t3,$t3,1
    beq $t3,4,printSpaceBin
printEndBin:
   	bne $t2,1,loopBinary


#Octal code
    li $v0, 4                  # syscall number 4 prints string whose address is in $a0
    la $a0, strPromptFour               
    syscall                    # actually print the string
    li $t2,0xC0000000
    li $t3,3
    and $s1,$t1,$t2
    beq $s1,0,noOct

loopOct:
	srl $s1,$s1,2
    bgt $s1,3,loopOct
noOct:
    li $v0,1  
    move $a0,$s1
    syscall

    li $t2,0x38000000
 	and $s1,$t1,$t2
    beq $s1,0,noOctFirst
loopOctFirst:
	srl $s1,$s1,3
    bgt $s1,3,loopOctFirst
noOctFirst:
    move $a0,$s1
    li $v0,1  
    syscall


loopOctal:
	srl $t2,$t2,3
	and $s1,$t1,$t2
	bne $s1,0,checkisOct
endCheckOct:
	move $a0,$s1
    li $v0,1  
    syscall
    add $t3,$t3,1
    beq $t3,4,printSpaceOct
printEndOct:
   	bne $t2,7,loopOctal


#Hexadecimal Code
	li $v0, 4                  # syscall number 4 prints string whose address is in $a0
    la $a0, strPromptFive               
    syscall                    # actually print the string
    li $t2,0xF0000000
    li $t3,1
    and $s1,$t1,$t2
    beq $s1,0,noHex
loopHex:
	srl $s1,$s1,4
    bgt $s1,8,loopHex
noHex:
    li $v0,1  
    move $a0,$s1
    syscall

loopHexad:
    srl $t2,$t2,4
    and $s1,$t1,$t2
    bne $s1,0,checkisHex
endCheckHex:
	la $t4,letter
	bgt $s1,9,printLetter
	add $s1,$s1,48
	j endAddHex
printLetter:
	add $s1,$s1,55
endAddHex:
	sb $s1,0($t4)
	la $a0,letter
    li $v0,4
    syscall
    add $t3,$t3,1
    beq $t3,4,printSpaceHex
printEndHex:
    bne $t2,15,loopHexad

###########
	
#Ask Continue
ask:
    li $v0, 4                  # syscall number 4 prints string whose address is in $a0
    la $a0, strPromptSix                
    syscall                    # actually print the string
    la $a0,buffer
    la $a1,buffer
    la $s2,strYes
    la $s3,strNo
    li $v0, 8                  # syscall number 5 reads an int
    syscall                    # actually read the int
    move $s4,$a0
    li $t0,0
    addi $t0,$t0,0				#make memory address to 0

    add $t1,$s2,$t0				
    lbu $t2,0($t1)				#load the address of "Y"

    add $t1,$s3,$t0
    lbu $t3,0($t1)				#load the address of "N"

    add $t1,$s4,$t0
    lbu $t5,0($t1)				#load the address of Input
   	beq $t2,$t5,main
   	beq $t3,$t5,exit
    j ask


exit:
    li $v0, 10                 # Syscall number 10 is to terminate the program
    syscall                    # exit now


loopBitBin:				#BinaryFunction
	srl $s1,$s1,1
checkisBin:
    bne $s1,1,loopBitBin
    j endCheckTwo
printSpaceBin:
	li $t3,0
	li $v0,4
	la $a0,strSpace
	syscall
	j printEndBin	#BinaryFunction End

loopBitOct:		#Octal Function
	srl $s1,$s1,3
checkisOct:
	bgt $s1,8,loopBitOct
    j endCheckOct
printSpaceOct:
	li $t3,0
	li $v0,4
	la $a0,strSpace
	syscall
	j printEndOct	#Octal Function End


loopBitHex:			#Hexadecimal Function
	srl $s1,$s1,4
checkisHex:
	bgt $s1,15,loopBitHex
    j endCheckHex
printSpaceHex:
	li $t3,0
	li $v0,4
	la $a0,strSpace
	syscall
	j printEndHex	#Hexadecimal Function end







    # Now read in the second number

   
    # Then compare the two numbers and print the larger one
    # Put the larger one into $t2
    # STEP 4 -- EXIT


##################
# End of Program #
##################
