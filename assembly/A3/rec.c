#include <stdio.h>
#include "rec.h"

void countBackwardFrom(int x)
{
	if( x<=1 )
	{
		printf( "1" );
		printf( "\n" );
	}
	else
	{
		printf( "%d, ", x );
		countBackwardFrom( x-1 );
	}
}

void countForwardTo(int x)
{
	if( x >=1 )
	{
		countForwardTo( x-1 );
		printf("%d, ", x);
	}
}


