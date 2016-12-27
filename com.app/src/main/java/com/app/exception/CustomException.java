package com.app.exception;

import com.app.util.messages.error.ErrorCodes;

public class CustomException extends BaseException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException()
	{
		super(ErrorCodes.CUSTOM_EXCEPTION_1);
	}
}
