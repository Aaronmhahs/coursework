; Aaron Hahs
; CPE225-03
; Assignment 7
;
; CHAR_COUNT FUNCTION
;
; 
;
; *************** CHAR_COUNT SETUP *****************************
;
	.ORIG x3300
	
CHAR_COUNT	
	ADD	R6, R6, #-2	; Push return value
	STR	R7, R6, #0	; Push return address
	ADD	R6, R6, #-1	
	STR	R5, R6, #0	; Push main frame pointer
	ADD	R6, R6, #-1	; Allocate memory for "count" variable
	ADD	R5, R6, #0	; Set new base pointer
	
; *************** CHAR_COUNT CODE *****************************

        ; if (*str == 0)      
        ;    result = 0;

IF	 
	LDR	R0, R5, #4	; Load address of word[increment]
	LDR	R2, R0, #0	; Load word[increment]
	ADD	R2, R2, #-1	; Check if 0
	BRzp	ELSEIF 	
 	AND	R0, R0, #0	; Set register equal to 0	
 	STR	R0, R5, #0	; Load counter
 	BRnzp	RETURN		; Return from base case
 
        ; else if (*str == c)
        ; result = 1 + charCount(str+1, c);

ELSEIF
	ADD	R2, R2, #1	; Set to original value
	NOT	R1, R2		; Set R1 to negative word[increment]
	ADD	R1, R1, #1	; Property
	LDR	R0, R5, #5	; Set R0 to c
	ADD	R2, R1, R0	; Check if same char
	BRnp	ELSE 
	AND	R1, R1, #0	; Set R1 to 0
	ADD	R1, R1, #1	; Set R1 to 1
	STR	R1, R5, #0	; Stores 1 in count
	BRnzp	REC		; Continues recursion
	

        ; else
        ;    result = charCount(str+1, c);

ELSE	
	AND	R1, R1, #0	; Set R1 to 0
	STR	R1, R5, #0	; Stores 0 in count
	BRnzp	REC		; Continues recursion
REC
	ADD	R6, R6, #-1	 
	LDR	R0, R5, #5	; Push c onto RT stack	
	STR	R0, R6, #0	
	ADD	R6, R6, #-1		
	LDR	R2, R5, #4	; Set R2 to point to word[i]
	ADD	R2, R2, #1	; Increment word pointer
	STR	R2, R6, #0	; Push word[i+1] onto RT stack	
		
	JSR	CHAR_COUNT	; Call CHAR_COUNT subroutine	
		
	LDR	R0, R6, #0	; Pop return value to R0
	ADD	R6, R6, #3	; Pop return and both arguments
	LDR	R1, R5, #0
	ADD	R2, R1, R0	; Adds return value to total and stores in memory for count
	STR	R2, R5, #0
	
	BRnzp	RETURN

; *************** CHAR_COUNT RETURN *****************************

	; return result;
RETURN	
	LDR	R0, R5, #0	; Load count result 
	STR	R0, R5, #3	; Write count result in return value slot
	ADD	R6, R5, #1	; Pop count variable
	LDR	R5, R6, #0	; Pop the dynamic link
	ADD	R6, R6, #1	
	LDR	R7, R6, #0	; Pop the return address
	ADD	R6, R6, #1

	RET

	.END
