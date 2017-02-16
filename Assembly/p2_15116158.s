#################################################################
#ReadMe 
#File: p2_15116158.s                                              #
#                                                               #
# This program is to have a Booth Algorithm to calculate the
# 5-bit binary multiplication
# The design of this program is that using the step of 
# Booth Algorithm to use different varible to present A Q Q_-1 and M
# 
# 
# You need to know:
# you should input two number  
# you should input two decimal number start by -16 up to 15
# 
# The multiplicand must not be -16 because -16 is the two's complement
# of 16 but 16 is out of the range of the 5bit two's complement system.                                                     
#################################################################

####################
# The data segment #
####################

                 .data

# Create some null terminated strings which are to be used in the program

strPromptFirst:  .asciiz "Enter a Multiplicand:  "
strPromptSecond: .asciiz "\nEnter a Multiplier:    "
strPromptThird:  .asciiz "\nAlgorithm starts . . .\n\n"
strPromptA:  .asciiz    "\n  A:     "
strPromptQ:  .asciiz    "\n  Q:     "
strPromptQtwo:  .asciiz "\n  Q_-1:      "
strPromptCA:  .asciiz    "\n   A:     "
strPromptCQ:  .asciiz    "\n   Q:     "
strPromptCQtwo:  .asciiz "\n   Q_-1:      "
strPromptM:  .asciiz    "\n  M:     "
strPromptMM:  .asciiz   "\n  -M:    "
strPromptQQQ: .asciiz   "\n  Q_0,Q_-1: "
strPromptAMM: .asciiz   "\n    A-M: "
strPromptAPM: .asciiz   "\n    A+M: "
strPromptShift: .asciiz "\n  Shift"
strPromptCycle:  .asciiz "\n\nCycle "
strPromptRinB:  .asciiz "\n\nResult in binary: "
strPromptRinD:  .asciiz "\nResult in decimal: "
strPromptCoinue:  .asciiz "\nContinue? (Y/N) "
strPromptbye:  .asciiz "\nBye! "
strNo:			.asciiz "N"
strYes:			.asciiz "Y"
strSpace:  .asciiz " "
buffer: .space 10

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
    move $s0, $v0              # save input in $s0
 
    li $v0, 4                  # syscall number 4 prints string whose address is in $a0
    la $a0, strPromptSecond     # "load address" of the string
    syscall                    # actually print the string

    # Now read in the first number

    li $v0, 5                  # syscall number 5 reads an int
    syscall                    # actually read the int
    move $s1, $v0              # save input in $s1

    li $v0, 4                  # syscall number 4 prints string whose address is in $a0
    la $a0, strPromptThird     # "load address" of the string
    syscall                    # actually print the string

    add $t0,$0,$0              # A is $t0
    move $t1,$s1               # Q is $t1
    add $t2,$0,$0              # Q _ -1 is $t2
    xor $t3,$s0,31             # M is $s0
    add $t3,$t3,1              # -M is $t3

    li $v0, 4                  # syscall number 4 prints string whose address is in $a0
    la $a0, strPromptA     # "load address" of the string
    syscall                    # actually print the string
    move $t4,$t0
    jal printBit

    li $v0, 4                  # syscall number 4 prints string whose address is in $a0
    la $a0, strPromptQ     # "load address" of the string
    syscall                    # actually print the string
    move $t4,$t1
    jal printBit
    
    li $v0, 4                  # syscall number 4 prints string whose address is in $a0
    la $a0, strPromptQtwo     # "load address" of the string
    syscall                    # actually print the string
    move $t4,$t2
    li $v0, 1
    move $a0,$t2
    syscall

    li $v0, 4                  # syscall number 4 prints string whose address is in $a0
    la $a0, strPromptM     # "load address" of the string
    syscall                    # actually print the string
    move $t4,$s0
    jal printBit    

    li $v0, 4                  # syscall number 4 prints string whose address is in $a0
    la $a0, strPromptMM     # "load address" of the string
    syscall                    # actually print the string
    move $t4,$t3
    jal printBit

    li $t7,1                   # set Cycle round to 1
Cycle:
    li $v0, 4                 # print the Cycle String  
    la $a0,strPromptCycle
    syscall 

    li $v0,1                   # print Cycle Round
    move $a0,$t7
    syscall

    li $v0, 4                  # print Q and Q_-1 String
    la $a0,strPromptQQQ
    syscall

    and $t6,$t1,1               # get the last bit of Q and store in Q_-1

    li $v0, 1                   # print the last bit of Q
    move $a0,$t6
    syscall

    li $v0, 1                   # print Q_-1 
    move $a0,$t2
    syscall

    beq $t6,$t2,shift           # if Q = Q_-1 go to shift
    beq $t6,1,AMM               # elseif Q = 1 go to A - M
    beq $t6,0,APM               # else if Q = 0 go to A + M
AMM:
    li $v0, 4 
    la $a0,strPromptAMM         # print A-M String
    syscall
    add $t0,$t0,$t3             # add -M to A
    and $t0,$t0,31              # and the 11111 to ignore the overflow bit
    move $t4,$t0                #print bit
    jal printBit
    j shift
APM:
    li $v0, 4 
    la $a0,strPromptAPM        # print A+M String
    syscall
    add $t0,$t0,$s0             # add M to A
    and $t0,$t0,31              # and the 11111 to ignore the overflow bit
    move $t4,$t0                #print bit
    jal printBit

shift:
    li $v0, 4 
    la $a0,strPromptShift       #print Shift String
    syscall
    and $t6,$t1,1               # get the last bit of Q
    move $t2,$t6                # set $t6 to $t2(Q_-1)
    srl $t1,$t1,1               # right shift A
    and $t6,$t0,1               # check the last bit of A is 1
    beq $t6,0,noadd             # if is 0 go to noadd
    add $t1,$t1,16              # else add the first bit 1 to Q 
noadd:
    
    and $t6,$t0,16              # check is the first bit of A is 1
    beq $t6,0,apadz             # if is 0 go to apadz

apado:
    srl $t0,$t0,1               # right shift A
    add $t0,16                  # add the first bit is 1
    j endpada                   # jump to endpada
apadz:              
    srl $t0,$t0,1               # right Shift A


endpada:
    li $v0, 4                   
    la $a0,strPromptCA          # Print String A and A
    syscall
    move $t4,$t0
    jal printBit

    li $v0, 4 
    la $a0,strPromptCQ          # Print String Q and Q 
    syscall
    move $t4,$t1
    jal printBit

    li $v0, 4 
    la $a0,strPromptCQtwo       # Print String Q_-1 
    syscall

    li $v0,1
    move $a0,$t2                # Print Q_-1
    syscall

    add $t7,$t7,1               # add 1 to Cycle round 
    bne $t7,6,Cycle             # check is that cycle round <=5 do again Cycle
    

    li $v0,4
    la $a0,strPromptRinB        # PRINT THE RESULT in binary
    syscall
    move $t4,$t0                
    jal printBit                

    li $v0,4
    la $a0,strSpace             # print a space
    syscall

    move $t4,$t1                #print the bit of result Q
    jal printBit

    li $v0,4
    la $a0,strPromptRinD        # print the Result in decimal
    syscall

    mult $s0,$s1
    mflo $t6                    # get the multipy of two number
    li $v0,1
    move $a0,$t6
    syscall



ask:
    li $v0, 4                  # syscall number 4 prints string whose address is in $a0
    la $a0, strPromptCoinue                
    syscall                    # actually print the string
    la $a0,buffer
    la $a1,buffer
    la $s2,strYes
    la $s3,strNo
    li $v0, 8                  # syscall number 5 reads an int
    syscall                    # actually read the int
    move $s4,$a0
    li $t0,0
    addi $t0,$t0,0              #make memory address to 0

    add $t1,$s2,$t0             
    lbu $t2,0($t1)              #load the address of "Y"

    add $t1,$s3,$t0
    lbu $t3,0($t1)              #load the address of "N"

    add $t1,$s4,$t0
    lbu $t5,0($t1)              #load the address of Input
    beq $t2,$t5,main
    beq $t3,$t5,exit
    j ask

exit:
    li $v0,4
    la $a0,strPromptbye
    syscall

    li $v0, 10                 # Syscall number 10 is to terminate the program
    syscall                    # exit now

printBit:
     li $t5,16     #give a mask  bit is  10000

loopBitBin:             
    and $t6,$t5,$t4

    beq $t6,0,endCheck
    beq $t6,1,endCheck
check:
    srl $t6,$t6,1
    bne $t6,1,check
endCheck:
    li $v0, 1
    move $a0,$t6
    syscall

    srl $t5,$t5,1
    bne $t5,0,loopBitBin
    jr $ra

##################
# End of Program #
##################
