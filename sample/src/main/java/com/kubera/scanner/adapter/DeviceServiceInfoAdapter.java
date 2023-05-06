package com.kubera.scanner.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kubera.easyble.gatt.bean.CharacteristicInfo;
import com.kubera.easyble.gatt.bean.ServiceInfo;
import com.kubera.scanner.R;

import java.util.List;

public class DeviceServiceInfoAdapter extends CommonExpandableListAdapter<ServiceInfo,CharacteristicInfo> {
    public DeviceServiceInfoAdapter(@NonNull Context context, @NonNull List<ServiceInfo> groupData,
                                    @NonNull List<List<CharacteristicInfo>> childData, int groupResLayout,
                                    int childResLayout, int[] groupViewIds, int[] childViewIds) {
        super(context, groupData, childData, groupResLayout, childResLayout, groupViewIds, childViewIds);
    }

    @Override
    public void bindDataToGroup(ViewGroup viewGroup, ViewHolder holder, ServiceInfo groupData, int groupPosition, boolean isExpanded) {
        TextView tvServiceUuid= (TextView) holder.mViews.get(R.id.tv_service_uuid);
        //tvServiceUuid.setText(ByteUtils.getUuidName(groupData.uuid));
        tvServiceUuid.setText(groupData.uuid);
    }

    @Override
    public void bindDataToChild(ViewGroup viewGroup, ViewHolder holder, CharacteristicInfo childData, int groupPosition, int childPosition, boolean isLastChild) {
        TextView tvUuid = (TextView) holder.mViews.get(R.id.tv_characteristic_uuid);
        TextView tvAttribution = (TextView) holder.mViews.get(R.id.tv_characteristic_attribution);
        //tvUuid.setText(ByteUtils.getUuidName(childData.uuid));
        tvUuid.setText(childData.uuid);
        String attri="";
        if (childData.notify){
            attri += "Notify  ";
        }
        if (childData.indicative){
            attri += "Indicate  ";
        }
        if (childData.readable){
            attri += "Read ";
        }
        if (childData.writable){
            attri += "Write ";
        }
        tvAttribution.setText(attri);
    }

}
