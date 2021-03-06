// ------------------------------------------------------------------------------
// Copyright (c) Microsoft Corporation.  All Rights Reserved.  Licensed under the MIT License.  See License in the project root for license information.
// ------------------------------------------------------------------------------

package com.microsoft.graph.requests.extensions;

import com.microsoft.graph.concurrency.*;
import com.microsoft.graph.core.*;
import com.microsoft.graph.models.extensions.*;
import com.microsoft.graph.models.generated.*;
import com.microsoft.graph.http.*;
import com.microsoft.graph.requests.extensions.*;
import com.microsoft.graph.options.*;
import com.microsoft.graph.serializer.*;

import java.util.Arrays;
import java.util.EnumSet;

// **NOTE** This file was generated by a tool and any changes will be overwritten.

/**
 * The class for the User Get Mail Tips Collection Request.
 */
public class UserGetMailTipsCollectionRequest extends BaseCollectionRequest<UserGetMailTipsCollectionResponse, IUserGetMailTipsCollectionPage> implements IUserGetMailTipsCollectionRequest {


    protected final UserGetMailTipsBody body;


    /**
     * The request for this UserGetMailTips
     *
     * @param requestUrl     the request URL
     * @param client         the service client
     * @param requestOptions the options for this request
     */
    public UserGetMailTipsCollectionRequest(final String requestUrl, final IBaseClient client, final java.util.List<? extends Option> requestOptions) {
        super(requestUrl, client, requestOptions, UserGetMailTipsCollectionResponse.class, IUserGetMailTipsCollectionPage.class);
        body = new UserGetMailTipsBody();
    }


    public void post(final ICallback<IUserGetMailTipsCollectionPage> callback) {
        final IExecutors executors = getBaseRequest().getClient().getExecutors();
        executors.performOnBackground(new Runnable() {
           @Override
           public void run() {
                try {
                    executors.performOnForeground(post(), callback);
                } catch (final ClientException e) {
                    executors.performOnForeground(e, callback);
                }
           }
        });
    }

    public IUserGetMailTipsCollectionPage post() throws ClientException {
        final UserGetMailTipsCollectionResponse response = post(body);
        return buildFromResponse(response);
    }


    public IUserGetMailTipsCollectionPage buildFromResponse(final UserGetMailTipsCollectionResponse response) {
        final IUserGetMailTipsCollectionRequestBuilder builder;
        if (response.nextLink != null) {
            builder = new UserGetMailTipsCollectionRequestBuilder(response.nextLink, getBaseRequest().getClient(), /* options */ null, /* emailAddresses */ null, /* mailTipsOptions */ null);
        } else {
            builder = null;
        }
        final IUserGetMailTipsCollectionPage page = new UserGetMailTipsCollectionPage(response, builder);
        page.setRawObject(response.getSerializer(), response.getRawObject());
        return page;
    }

    /**
     * Sets the select clause for the request
     *
     * @param value the select clause
     * @return the updated request
     */
    public IUserGetMailTipsCollectionRequest select(final String value) {
        addQueryOption(new QueryOption("$select", value));
        return (IUserGetMailTipsCollectionRequest)this;
    }

    /**
     * Sets the top value for the request
     *
     * @param value the max number of items to return
     * @return the updated request
     */
    public IUserGetMailTipsCollectionRequest top(final int value) {
        addQueryOption(new QueryOption("$top", value+""));
        return (IUserGetMailTipsCollectionRequest)this;
    }

    /**
     * Sets the expand clause for the request
     *
     * @param value the expand clause
     * @return the updated request
     */
    public IUserGetMailTipsCollectionRequest expand(final String value) {
        addQueryOption(new QueryOption("$expand", value));
        return (IUserGetMailTipsCollectionRequest)this;
    }

}
