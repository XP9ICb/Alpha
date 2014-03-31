<div class="modal fade" id="new-expertise-modal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">${modalExpertiseHeader}</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="new-expertise-form">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="startdate">${startDate}</label>

                            <div class="col-md-3">
                                <input type="text" class="form-control" name="startdate" data-date-format="yyyy-mm-dd" id="startdate" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="organization">${organization}</label>

                            <div class="col-md-8">
                                <input class="form-control" type="text" name="organization" id="organization"
                                       placeholder="${organization}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="crimenumber">${crimeNumber}</label>

                            <div class="col-md-8">
                                <input class="form-control" type="text" name="crimenumber" id="crimenumber"
                                       placeholder="${crimeNumber}">
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">${close}</button>
                <button id="save" type="button" class="btn btn-primary">${save}</button>
            </div>
        </div>
    </div>
</div>
